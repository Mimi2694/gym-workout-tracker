package com.fittrackpro.model;

public class BodyWeightLog {
    private String date;
    private double bodyWeight;

    public BodyWeightLog(String date, double bodyWeight) {
        this.date = date;
        this.bodyWeight = bodyWeight;
    }

    public String getDate() {
        return date;
    }

    public double getBodyWeight() {
        return bodyWeight;
    }
}