#include "StringUtilities.h"

JNIEXPORT jint JNICALL Java_StringUtilities_getHashOf
  (JNIEnv* env, jclass cls, jstring text)
{
	jint hash = 0;
	jint n = env->GetStringLength(text);
	jboolean iscopy;
	const jchar* buffer = env->GetStringChars(text, &iscopy);
	
	for(jint i = 0; i < n; i++)
		hash = buffer[i] + (hash << 6) + (hash << 16) - hash;
		
	env->ReleaseStringChars(text, buffer);

	return hash;
}

JNIEXPORT jstring JNICALL Java_StringUtilities_getReverseOf
  (JNIEnv* env, jclass cls, jstring text)
{
	jint n = env->GetStringLength(text);
	jchar* buffer = new jchar[n];
	env->GetStringRegion(text, 0, n, buffer);
	
	for(jint i = 0, j = n - 1; i < j; i++, j--)
	{
		jchar ic = buffer[i];
		jchar jc = buffer[j];

		buffer[i] = jc;
		buffer[j] = ic;
	}

	jstring reversed = env->NewString(buffer, n);
	delete[] buffer;

	return reversed;
}


















