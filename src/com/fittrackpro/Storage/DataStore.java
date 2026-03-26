package com.fittrackpro.Storage;

import java.util.ArrayList;
import java.util.List;
import com.fittrackpro.model.ExerciseLog;
import com.fittrackpro.model.BodyWeightLog;

public class DataStore {
    private static DataStore instance;

    private List<ExerciseLog> exerciseLogs;
    private List<BodyWeightLog> bodyWeightLogs;

    private DataStore() {
        exerciseLogs = new ArrayList<>();
        bodyWeightLogs = new ArrayList<>();
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public void addExerciseLog(ExerciseLog log) {
        exerciseLogs.add(log);
    }

    public void addBodyWeightLog(BodyWeightLog log) {
        bodyWeightLogs.add(log);
    }

    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogs;
    }

    public List<BodyWeightLog> getBodyWeightLogs() {
        return bodyWeightLogs;
    }
}