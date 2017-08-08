package fr.kata.lags;

public class Request implements Comparable<Request> {

    private String name;
    private int start;
    private int duration;
    private int price;

    private Request(String name, int start, int duration, int price) {
        // todo check invariants
        this.name = name;
        this.start = start;
        this.duration = duration;
        this.price = price;
    }

    public int getStart() {
        return start;
    }

    public int getPrice() {
        return price;
    }

    public int getEnd() {
        return start + duration;
    }

    public static Request of(String input) {
        // todo error management
        String[] inputValues = input.split(" ");
        String name = inputValues[0];
        int start = Integer.valueOf(inputValues[1]);
        int duration = Integer.valueOf(inputValues[2]);
        int price = Integer.valueOf(inputValues[3]);
        return new Request(name, start, duration, price);
    }

    static final int IS_BEFORE = -1;
    static final int IS_AT_SAME_TIME = 0;
    static final int IS_AFTER = 1;

    @Override
    public int compareTo(Request o) {
        if (this.getEnd() <= o.getStart()) return IS_BEFORE;
        if (o.getEnd() <= this.getStart()) return IS_AFTER;
        return IS_AT_SAME_TIME;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d", name, start, duration, price);
    }
}


