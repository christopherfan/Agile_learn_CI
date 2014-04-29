package edu.berkeley.ischool.aep;

/**
 * Created by Thoughtworker on 3/7/14.
 */
public interface Bestable<T> {
    boolean betterThan(T other);
}
