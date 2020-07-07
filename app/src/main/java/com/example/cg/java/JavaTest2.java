package com.example.cg.java;

import com.example.cg.pattern.decorator.Person;

public class JavaTest2 {

    JavaTest javaTest = new JavaTest();
    JavaTest.Test test1 = javaTest.getIntense();

}


class People{

}

class Man{
    public Man() {
    }

    public People getWoman(){

        class Woman extends People{

            int age = 0;

            class XiaoHai extends People{
                int age = 1;

            }
        }

        return new Woman();
    }
}