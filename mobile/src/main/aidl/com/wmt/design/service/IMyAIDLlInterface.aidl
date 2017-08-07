// IMyAIDLlInterface.aidl
package com.wmt.design.service;

// Declare any non-default types here with import statements

interface IMyAIDLlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
