package model;

import java.util.List;

public class GameResult {
    private User user;
    private int resultNumber;
    private int countOfAttempt;

    public GameResult(User user, int resultNumber, int countOfAttempt) {
        this.user = user;
        this.resultNumber = resultNumber;
        this.countOfAttempt = countOfAttempt;
    }

    public List<String> getUserMap() {
        return user.getUserMap();
    }

    public int getResultNumber() {
        return resultNumber;
    }

    public int getCountOfAttempt() {
        return countOfAttempt;
    }
}
