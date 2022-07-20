package org.singleton;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        long start,end;
        start =System.currentTimeMillis();
        printer printer1= printer.getPublicPrinter();
        end = System.currentTimeMillis();
        System.out.println(printer1);

        Connection connection = printer1.getConnection();
        start = System.currentTimeMillis();
        printer printer2 =printer.getPublicPrinter();
        end= System.currentTimeMillis();
        System.out.println(printer2);

    }
}