package com.company;

public class ATC extends Thread {
    private final int SLEEP_TIME = 4000;
    private final int NUMBER_OF_NEW_CALLS = 12;
    private int NUMBER_ITERATIONS = 5;
    PhonecallsPool pool;

    public ATC(PhonecallsPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        System.out.println("Рабочий день начался.");
        while (NUMBER_ITERATIONS != 0) {
            try {
                for (int i = 0; i < NUMBER_OF_NEW_CALLS; i++) {
                    pool.addIncomeCall(i);
                }
                System.out.println("На линии " + NUMBER_OF_NEW_CALLS + " новых звонков!");
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            NUMBER_ITERATIONS--;
        }
    }
}
