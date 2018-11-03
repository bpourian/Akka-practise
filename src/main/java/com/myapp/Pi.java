package com.myapp;

import com.myapp.message.Calculate;

public class Pi {

    public static void main(String[] args) {
//        Pi pi = new Pi();
//        pi.calculate(4, 10000, 10000);

        Calculate calculate = new Calculate();

        calculate.calculate(4, 10000, 10000);
    }
}