package com.example.cg.java;

import java.util.HashMap;
import java.util.Hashtable;

public class ObjectTool<A> {
    private A obj;

    HashMap hashMap = new HashMap();


    public A getObj() {
        return obj;
    }

    public void setObj(A obj) {
        this.obj = obj;
    }
}
