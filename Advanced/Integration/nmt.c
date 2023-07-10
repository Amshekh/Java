#include <jni.h>
#include <fcntl.h>
#include <sys/mman.h>

char* shbuf;

jint Java_NativeMethodTest_readShared(JNIEnv* env, jclass cls, 
		jint index)
{
	if(index < 0 || index > 4095)
		return -1;
	
	if(shbuf == NULL)
	{
		int fdsm = shm_open("testshm", O_RDONLY, 0);
		if(fdsm == -1)
			return -2;
		shbuf = mmap(NULL, 4096, PROT_READ, 
			MAP_FILE | MAP_SHARED, fdsm, 0);
	}

	return shbuf[index];
}















