package com.fittrackpro.model;

public class ExerciseLog {
    private String exerciseName;
    private int sets;
    private int reps;
    private double weight;

    public ExerciseLog(String exerciseName, int sets, int reps, double weight) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public double getWeight() {
        return weight;
    }
}