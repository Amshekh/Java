#include "StringUtilities.h"


JNIEXPORT jint JNICALL Java_StringUtilities_hashOf
  (JNIEnv* env, jclass, jstring text)
{
	jint n = env->GetStringLength(text);
	jboolean iscopy;
	const jchar* buffer = env->GetStringChars(text, &iscopy);
	jint result = 0;

	for(jint i = 0; i < n; i++)
		result = buffer[i] + (result << 6) 
			+ (result << 16) - result;
	
	env->ReleaseStringChars(text, buffer);

	return result;
}

JNIEXPORT jstring JNICALL Java_StringUtilities_reverseOf
  (JNIEnv* env, jclass, jstring text)
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

	jstring result = env->NewString(buffer, n);
	delete[] buffer;

	return result;
}























