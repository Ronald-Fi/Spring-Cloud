package com.example.domain;

public enum SeasonEnum {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);

    private int seq;

    SeasonEnum(int seq) {
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Jack").append("Ma")
                .append("alibaba")
                .append("alibaba");
    }
}
