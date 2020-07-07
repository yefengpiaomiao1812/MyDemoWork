package com.example.cg.rxjava;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxJava {

    private void doSomeWork() {
        Observable<String> observable =
                Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> e) throws Exception {
                        e.onNext("a");
                        e.onComplete();
                    }
                });

        Observer observer = new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.i("lx", "onSubscribe :" + d.isDisposed());
            }

            @Override
            public void onNext(String str) {
                Log.i("lx", " onNext : " +str);
            }

            @Override
            public void
            onError(Throwable e) {
                Log.i("lx", " onError : " +e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i("lx", "onComplete");
            }
        };

        observable.subscribe(observer);
    }

}
