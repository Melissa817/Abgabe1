package org.example;

public class Rohdaten {
    private int id;
    private double wert;
    private String timestamp;

    public Rohdaten(int id, double wert, String timestamp) {
        this.id = id;
        this.wert = wert;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public double getWert() {
        return wert;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
