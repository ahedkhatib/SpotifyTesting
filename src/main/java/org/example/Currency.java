package org.example;

public class Currency {
    private String code;
    private String symbol;

    public Currency(String code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }


    @Override
    public String toString() {
        return code + " (" + symbol + ")";
    }
}
