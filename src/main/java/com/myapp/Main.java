package com.myapp;

import com.myapp.controller.Pi;

public class Main {

    public static void main(String[] args) {
        Pi pi = new Pi();
        pi.calculate(15, 10000, 10000);

    }
}