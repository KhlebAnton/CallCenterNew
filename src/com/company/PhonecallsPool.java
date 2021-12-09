package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

public class PhonecallsPool {

    private final ConcurrentLinkedQueue<Integer> callPool = new ConcurrentLinkedQueue<>();

    public void addIncomeCall(Integer call) {
        callPool.add(call);
    }

    public Integer removeIncomingCallOrReturnNullIfEmpty() {
        return callPool.poll();
    }

    public boolean isEmpty() {
        return callPool.peek() == null;
    }

}