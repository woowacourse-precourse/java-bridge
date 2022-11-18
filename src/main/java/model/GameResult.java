package model;

import controller.MapConverter;

public class GameResult {
    private User user;
    private int resultNumber;
    private int countOfAttempt;

    public GameResult(User user, int resultNumber, int countOfAttempt) {
        this.user = user;
        this.resultNumber = resultNumber;
        this.countOfAttempt = countOfAttempt;
    }

    public User getUser() {
        return user;
    }

    public int getResultNumber() {
        return resultNumber;
    }

    public int getCountOfAttempt() {
        return countOfAttempt;
    }
}
