package com.revature.service;

public class P1DataException extends RuntimeException{
    public P1DataException() {}
    public P1DataException(String msg) {
        super(msg);
    }
    public P1DataException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
