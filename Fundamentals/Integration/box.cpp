#include "LegacyBox.h"

extern "C" long BoxVolume(long, long, long, short);

JNIEXPORT jint JNICALL Java_LegacyBox_getInnerVolume
  (JNIEnv* env, jobject obj, jshort thickness)
{
	jclass cls = env->GetObjectClass(obj);
	jfieldID idLength = env->GetFieldID(cls, "length", "I");
	jint length = env->GetIntField(obj, idLength);
	jfieldID idBreadth = env->GetFieldID(cls, "breadth", "I");
	jint breadth = env->GetIntField(obj, idBreadth);
	jfieldID idHeight = env->GetFieldID(cls, "height", "I");
	jint height = env->GetIntField(obj, idHeight);
	jmethodID idIsValid = env->GetMethodID(cls, "isValid", "(S)Z");
	jboolean valid = env->CallBooleanMethod(obj, idIsValid, thickness);

	if(valid == JNI_FALSE)
	{
		jclass ex = env->FindClass("java/lang/IllegalArgumentException");
		env->ThrowNew(ex, "Invalid box thickness");
		return 0;
	}

	return BoxVolume(length, breadth, height, thickness);
}













