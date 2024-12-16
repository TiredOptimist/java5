package ru.pankova.task_4;

public class Information {
    private String lastName;
    private String firstName;
    private int[] scores;
    private int totalScore;

    Information(String lastName, String firstName, int[] scores) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.scores = scores;
        this.totalScore = calculateTotalScore();
    }

    private int calculateTotalScore() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    int getTotalScore() {
        return totalScore;
    }

    public String toString() {
        return lastName + " " + firstName;
    }
}
