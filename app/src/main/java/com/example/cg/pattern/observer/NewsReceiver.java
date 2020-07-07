package com.example.cg.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 *
 *新闻接收者
 */
public class NewsReceiver implements Observer {

    private String name = "";
    private String message = "";

    public NewsReceiver(String name){
        this.name = name;
    }


    @Override
    public void update(Observable o, Object arg) {

        this.setMessage((String) arg);
        System.out.print(name + ":" + message);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
