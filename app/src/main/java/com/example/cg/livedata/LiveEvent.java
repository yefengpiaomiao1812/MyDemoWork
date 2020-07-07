package com.example.cg.livedata;

/**
 * LiveEvent消息
 */
public class LiveEvent {
    private String msg;
    private Object object;

    public LiveEvent(String msg, Object object) {
        this.msg = msg;
        this.object = object;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
