#include <jni.h>
#include <fcntl.h>
#include <sys/mman.h>

char* shbuf;

jint Java_NativeMethodTest_readShared(JNIEnv* env, jclass cls, jint index)
{
	if(shbuf != NULL && index >= 0 && index < 4096)
		return shbuf[index];

	return -1;
}

jint JNI_OnLoad(JavaVM* jvm, void* reserved)
{
	int fdsm = shm_open("testshm", O_RDONLY, 0);
	
	if(fdsm != -1)
		shbuf = mmap(NULL, 4096, PROT_READ, 
			MAP_FILE | MAP_SHARED, fdsm, 0);
	
	return JNI_VERSION_1_6;
}











