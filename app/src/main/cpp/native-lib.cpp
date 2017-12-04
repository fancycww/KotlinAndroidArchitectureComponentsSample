#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_cww_sample_kotlin_splash_views_SplashScreenActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello Kotlin!";
    return env->NewStringUTF(hello.c_str());
}
