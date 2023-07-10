#include "ArrayUtilities.h"


JNIEXPORT jdouble JNICALL Java_ArrayUtilities_sumOf
  (JNIEnv* env, jclass, jdoubleArray list)
{
	jint n = env->GetArrayLength(list);
	jdouble* values = env->GetDoubleArrayElements(list, NULL);
	jdouble total = 0;

	for(jint i = 0; i < n; i++)
		total += values[i];

	env->ReleaseDoubleArrayElements(list, values, JNI_ABORT);

	return total;
}

JNIEXPORT void JNICALL Java_ArrayUtilities_squareAll
  (JNIEnv* env, jclass, jdoubleArray list)
{
	jint n = env->GetArrayLength(list);
	jdouble* values = new jdouble[n];
	env->GetDoubleArrayRegion(list, 0, n, values);

	for(jint i = 0; i < n; i++)
		values[i] *= values[i];
	
	env->SetDoubleArrayRegion(list, 0, n, values);
	delete[] values;
}



















