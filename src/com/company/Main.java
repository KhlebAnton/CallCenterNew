package com.company;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PhonecallsPool pool = new PhonecallsPool();
        ATC atc = new ATC(pool);
        atc.start();

        List<Operator> operators = Stream.of(
                        new Operator("Анна", pool),
                        new Operator("Иван", pool),
                        new Operator("Олег", pool))
                .collect(Collectors.toList());
        for (Operator operator : operators) {
            operator.start();
        }
        for (Operator operator : operators) {
            operator.join();
        }
    }
}
