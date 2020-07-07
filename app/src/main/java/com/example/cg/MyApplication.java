package com.example.cg;

import android.app.Application;



public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //String rootDir = MMKV.initialize(this);
        //System.out.println("mmkv root: " + rootDir);
    }

//    private RefWatcher refWatcher;
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        refWatcher= setupLeakCanary();
//    }
//
//    private RefWatcher setupLeakCanary() {
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return RefWatcher.DISABLED;
//        }
//        return LeakCanary.install(this);
//    }
//
//    public static RefWatcher getRefWatcher(Context context) {
//        MyApplication leakApplication = (MyApplication) context.getApplicationContext();
//        return leakApplication.refWatcher;
//    }
}
