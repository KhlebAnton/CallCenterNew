package com.company;

public class Operator extends Thread {
    private final int WORKTIME = 2000;
    private final String name;
    PhonecallsPool pool;

    public Operator(String name, PhonecallsPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {
        boolean needToRepeat = true;
        while (needToRepeat) {
            if (!pool.isEmpty()) {
                while (needToRepeat) {
                    try {
                        Integer call = pool.removeIncomingCallOrReturnNullIfEmpty();
                        if (call != null) {
                            System.out.println("Оператор " + name + " берет нового клиента");
                            Thread.sleep(WORKTIME);
                            System.out.println("Оператор " + name + " отработал звонок.");
                        } else {
                            System.out.println("Оператор " + name + " завершил работу в этот день.");
                            Thread.currentThread().interrupt();
                            needToRepeat = false;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
