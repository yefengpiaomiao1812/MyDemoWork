package com.example.cg.livedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * LiveDataBus组建通信类
 * @author CG
 * @date 2020/04/30
 */
public class LiveDataBus {

    // 单例
    private static volatile LiveDataBus instance = null;

    // 装在整个应用所有的数据持有类的容器
    private Map<String, BusMutableLiveData<Object>> map;

    // 构造方法
    private LiveDataBus() {
        map = new HashMap<>();
    }

    // 获取单例
    public static LiveDataBus getInstance() {
        if(instance == null){
            synchronized (LiveDataBus.class){
                if(instance == null){
                    instance = new LiveDataBus();
                }
            }
        }
        return instance;
    }


    /**
     * 注册订阅方法 set和get结合到一起
     *
     * @param key
     * @param type
     * @param <T>
     * @return
     */
    public synchronized <T> BusMutableLiveData<T> with(String key, Class<T> type) {

        if (!map.containsKey(key)) {
            map.put(key, new BusMutableLiveData<Object>());
        }
        return (BusMutableLiveData<T>) map.get(key);
    }


    /**
     * 粘性事件控制类
     * @param <T>
     */
    public class BusMutableLiveData<T> extends MutableLiveData<T> {

        // 是否粘性事件(true能接收到/false不能接收)
        private boolean isVisicosity = false;

        public void observe(@NonNull LifecycleOwner owner, boolean isVisicosity, @NonNull Observer<? super T> observer) {
            this.isVisicosity = isVisicosity;
            observe(owner, observer);
        }

        @Override
        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
            super.observe(owner, observer);
            try {
                if (!isVisicosity) {
                    hook(observer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * hook技术的实现方法(先订阅 后接受)
         * 获取到observer的mLastVersion变量  获取mVersion的变量  然后将mLastVersion = mVersion
         *
         * @param observer
         * @throws Exception
         */
        private void hook(Observer<? super T> observer) throws Exception {
            // 获取liveData的类对象
            Class<LiveData> LiveDataClass = LiveData.class;
            // 根据类对象获取mVersion的反射对象
            Field mVersionField = LiveDataClass.getDeclaredField("mVersion");
            // 打开权限
            mVersionField.setAccessible(true);
            // 获取   LiveData类的mObservers对象 （Map对象）的 Field对象
            Field mObserversField = LiveDataClass.getDeclaredField("mObservers");
            // 打开权限
            mObserversField.setAccessible(true);
            // 获取这个成员变量在当前对象中的值
            Object mObservers = mObserversField.get(this);
            // 获取到mObservers这个map的get方法
            Method get = mObservers.getClass().getDeclaredMethod("get", Object.class);
            // 打开权限
            get.setAccessible(true);
            // 执行get方法
            Object invokeEntry = get.invoke(mObservers, observer);
            // 定义一个空对象
            Object observerWrapper = null;
            if (invokeEntry != null && invokeEntry instanceof Map.Entry) {
                observerWrapper = ((Map.Entry) invokeEntry).getValue();
            }
            if (observerWrapper == null) {
                throw new NullPointerException("observerWrapper can not be null");
            }

            // 得到observerWrapper的类对象
            Class<?> aClass = observerWrapper.getClass().getSuperclass();
            // 获取mLastVersion的发射对象
            Field mLastVersionField = aClass.getDeclaredField("mLastVersion");
            // 打开权限
            mLastVersionField.setAccessible(true);
            // 获取mVersion的值
            Object o = mVersionField.get(this);
            // 把它的值赋给mLastVersion
            mLastVersionField.set(observerWrapper, o);

        }
    }


}


/*
*--------------------用法示例-----------------------/
* String.class可以自定义ObjectEvent
发送：-----------------------------------------------------------------------------------------------------------------/
*       // 注册LiveDataBus  发送消息
        LiveDataBus.getInstance()
                 .with("user", String.class)
                 .postValue("MainActivity 发送liveDataBus啦~~~~~");

接收：----------------------------------------------------------------------------------------------------------------/
*       // 接收LiveDataBus消息
        LiveDataBus.getInstance()
                .with("user", String.class)
                .observe(this, false, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Log.i("LiveDataActivity", "收到消息-----" + s);
                    }
                });
 ----------------------------------------------------------------------------------------------------------------------/
 */
