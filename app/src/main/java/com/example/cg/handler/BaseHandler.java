package com.example.cg.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * 防止Handler内存溢出
 * 定义抽象类
  @param <T>
 */
public abstract class BaseHandler<T> extends Handler {

    private final WeakReference<T> mReference;

    protected BaseHandler(T t) {
        super(Looper.getMainLooper());
        mReference = new WeakReference<>(t);
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
       T t = mReference.get();
       if(t != null){
           handleMessage(t, msg);
       }
    }

    protected abstract void handleMessage(T t, Message msg);
}
