package com.example.cg.pattern.observer;

import java.util.Observable;

/**
 * 新闻发布者
 */
public class NewsObservable extends Observable {

    private String message = null;

    public void releaseNews(String news){
        this.setMessage(news);
        setChanged();
        notifyObservers(news);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
