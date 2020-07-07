package com.example.cg.pattern.decorator;

/**
 * 穿衣类型
 */
public class PersonCloth extends Person{

    // 持有人对象的引用
    protected Person person;

    PersonCloth(Person person){
        this.person = person;
    }

    @Override
    public void dressed() {
        this.person.dressed();
    }
}
