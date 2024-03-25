package com.spring.calculator;

import jakarta.validation.constraints.Min;

public class Number {
    @Min(value=0, message = "Validacijos klaida: skaičius negali būti neigiamas.")
    private int num1;
    @Min(value=0, message = "Validacijos klaida: skaičius negali būti neigiamas.")
    private int num2;
    private String operation;
    private int result;

    public Number(int num1, int num2, String operation, int result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }
    public Number() {}
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Number{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                '}';
    }
}
