package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private boolean isSuccess;
    private int totalTry;
    private List<String> select;

    public User() {
        this.isSuccess = false;
        this.totalTry = 0;
        this.select = new ArrayList<>();
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void resetSelect() {
        select = new ArrayList<>();
    }

    public void addSelect(String word) {
        select.add(word);
    }

    public int getPosition() {
        return select.size();
    }

    public String getIndexSelect(int index) {
        return select.get(index);
    }

    public int getTotalTry() {
        return totalTry;
    }

    public void tryAgain() {
        this.totalTry = this.totalTry + 1;
    }
}
