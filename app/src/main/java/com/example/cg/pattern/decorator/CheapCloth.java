package com.example.cg.pattern.decorator;

/**
 * 普通衣服
 */
public class CheapCloth extends PersonCloth{
    public CheapCloth(Person person) {
        super(person);
    }


    /**
     * 穿短裤
     */
    public void dressShorts(){
        System.out.println("穿条短裤");
    }


    @Override
    public void dressed() {
        super.dressed();
        dressShorts();
    }
}
