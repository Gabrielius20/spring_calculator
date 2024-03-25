package com.spring.calculator;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class Number {
    @PositiveOrZero(message = "Number must be positive!")
    private int num1;

    @PositiveOrZero(message = "Number must be positive!")
    private int num2;
    private String symbol;
    private int result;

    public Number() {

    }

    public Number(int num1, int num2, String symbol, int result) {
        this.num1 = num1;
        this.num2 = num2;
        this.symbol = symbol;
        this.result = result;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
