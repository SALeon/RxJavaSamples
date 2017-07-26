package ru.gdgkazan.rxjavasamples.tasks;

import android.support.annotation.NonNull;

import java.math.BigInteger;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.observables.MathObservable;

import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

import static rx.android.schedulers.AndroidSchedulers.mainThread;

/**
 * @author Artur Vasilov
 */
public class RxJavaTask6 {

    /**
     * TODO :
     * <p>
     * Create the stream of integers [1..100000] and apply next functions:
     * 1) Multiply all elements by 2
     * 2) Remove 40 000 elements from start and 40 000 elements from end
     * 3) Remove all values which is not divided by 3
     * 4) Find multiplication of all values in the stream and transform into one single BigInteger
     * 5) Operations above are rather slow. Try to calculate result in observable only once.
     * You code will be also tested for speed - you shouldn't recalculate result for each new subscriber.
     */
    @NonNull
    public static Observable<BigInteger> task6Observable() {
        Observable temp = Observable.range(1, 100000);
        return temp.map(s -> new BigInteger(s.toString()));
    }

    public static void main(String[] args) {
//        task6Observable().subscribe(s -> {
//            s = s.multiply(BigInteger.valueOf(Long.valueOf("2")));
//            System.out.println(s);
//        });

//        task6Observable()
//                .skip(39999)
//                .skipLast(40001)
//                .subscribe(System.out::println);

        task6Observable().filter(s ->
                !(s.divideAndRemainder(new BigInteger("3")))[1].equals(
                        new BigInteger("0"))
        ).subscribe(System.out::println);


    }

}