#include "ArrayUtilities.h"


JNIEXPORT jdouble JNICALL Java_ArrayUtilities_sumOf
  (JNIEnv* env, jclass cls, jdoubleArray values)
{
	jdouble sum = 0;
	jint n = env->GetArrayLength(values);
	jdouble* elements = env->GetDoubleArrayElements(values, NULL);

	for(jint i = 0; i < n; i++)
		sum += elements[i];

	env->ReleaseDoubleArrayElements(values, elements, JNI_ABORT);
	
	return sum;
}

JNIEXPORT void JNICALL Java_ArrayUtilities_squareAll
  (JNIEnv* env, jclass cls, jdoubleArray values)
{
	jint n = env->GetArrayLength(values);
	jdouble* elements = new jdouble[n];
	env->GetDoubleArrayRegion(values, 0, n, elements);

	for(jint i = 0; i < n; i++)
		elements[i] *= elements[i];

	env->SetDoubleArrayRegion(values, 0, n, elements);
	delete[] elements;
}




















