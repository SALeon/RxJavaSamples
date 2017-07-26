package ru.gdgkazan.rxjavasamples.tasks;

import android.support.annotation.NonNull;

import java.math.BigInteger;

import rx.Observable;
import rx.functions.Func2;

/**
 * @author Artur Vasilov
 */
public class RxJavaTask5 {

    /**
     * TODO : you have two streams of integers of equal length
     * <p>
     * Return one stream of the same length with GCDs
     * of the original streams values
     * <p>
     * Example:
     * Stream 1 (100, 17, 63)
     * Stream 2 (15, 89, 27)
     * Result stream (5, 1, 9)
     * <p>
     * You can use {@link java.math.BigInteger#gcd(BigInteger)}
     */
    @NonNull
    public static Observable<Integer> gcdsObservable(@NonNull Observable<Integer> first,
                                                     @NonNull Observable<Integer> second) {
        return Observable.zip(first, second, new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer firstValue, Integer secondValue) {
                int minValue = 0;
                int valueGCD = 0;
                if (firstValue < secondValue) minValue = firstValue;
                else minValue = secondValue;
                for (int k = 1; k < minValue; k++) {
                    if (secondValue % k == 0 && firstValue % k == 0) valueGCD = k;
                }
                return valueGCD;
            }
        });
    }

    public static void main(String[] args) {
        Observable<Integer> first = Observable.just(100, 17, 63);
        Observable<Integer> second = Observable.just(15, 89, 27);

        gcdsObservable(first,second).subscribe(System.out::println);
    }

}
