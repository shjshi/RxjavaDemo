package com.shj.rxjavademo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by Reus on 2017/4/19.
 */

public class SimpleActivity1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();


    }

    private void test6() {
        Observable.just("Hello, world!")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .subscribe(s -> System.out.println(s));
    }

    private void test5() {
        Observable.just("Hello, world!")
                .subscribe(s -> Log.d("shj--",s));
    }

    private void test4() {
        Observable.just("shj").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("shj--",s);
            }
        });
    }

    private void test3() {
        Observable<String> myObservable = Observable.just("Hello, world!");
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("shj--",s);
            }
        };
        myObservable.subscribe(onNextAction);
    }

    private void test2() {
        Log.d("shj--","hello world");
    }

    private void test1() {
        //创建一个Observables对象
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello world");
                subscriber.onCompleted();
            }
        });
        //创建Subscriber处理Observable对象发出的字符串
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("shj--",s);
            }
        };
        myObservable.subscribe(mySubscriber);
    }

}






















