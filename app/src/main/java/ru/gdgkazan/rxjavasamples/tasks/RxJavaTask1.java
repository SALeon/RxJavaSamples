package ru.gdgkazan.rxjavasamples.tasks;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Artur Vasilov
 */
public class RxJavaTask1 {

    /**
     * TODO : implement this method
     * <p>
     * This method takes list of strings and creates an observable of integers,
     * that represents length of strings which contains letter 'r' (or 'R')
     * <p>
     * Example:
     * Input list: ("Vasya", "Dima", "Artur", "Petya", "Roma")
     * Result stream: (5, 4)
     */
    @NonNull
    public static Observable<Integer> task1(@NonNull List<String> list) {
       return Observable.from(list)
//               .subscribeOn(Schedulers.io())
                .filter(r->r.contains("r")||r.contains("R"))
                .flatMap(s->Observable.just(s.length()));

    }
//        static Subscriber<Integer> mSubscriber=new Subscriber<Integer>(){
//
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println(integer);
//            }
//
////            @Override
////            public void onNext(String s) {
////
////            }
//        };

static List<String>mStrings=new ArrayList<>();


    public static void main(String[] args) {
        mStrings.add("Vasya");
        mStrings.add("Dima");
        mStrings.add("Artur");
        mStrings.add("Petya");
        mStrings.add("Roma");
        task1(mStrings).subscribe(s-> System.out.println(s));
    }

}