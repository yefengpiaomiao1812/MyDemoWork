package com.example.cg.pattern.adapter;

public class TypeAdapter extends TypeCImpl implements MicroUSB{
    @Override
    public void isMicroUSB() {
        isTypeC();
    }
}
