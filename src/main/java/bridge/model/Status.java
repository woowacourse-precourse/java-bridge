package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private List<String> status;
    private int tryNumber;

    public Status() {
        this.status = new ArrayList<>();
    }

    public void add(String whereMoving) {
        status.add(whereMoving);
    }

    public void remove(int step) {
        status.remove(step);
    }

    public int size() {
        return status.size();
    }

    public String get(int index) {
        return status.get(index);
    }

    public String pop() {
        return status.get(status.size()-1);
    }

    public void raiseTryNumber() {
        tryNumber ++;
    }

    public void setZeroTryNumber() {
        tryNumber = 0;
    }

    public void setOneTryNumber() {
        tryNumber = 1;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}