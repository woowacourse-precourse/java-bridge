package bridge.domain;

import java.util.ArrayList;

public class User {

    private final ArrayList<String> userMovings = new ArrayList<>();
    private int count;

    public User() {
        this.count = 1;
    }

    public void addUserMoving(String moving) {
        this.userMovings.add(moving);

    }

    public ArrayList<String> getUserMovings() {
        return userMovings;
    }

    public void clearUserMoving() {
        this.userMovings.clear();
        addCount();
    }

    private void addCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
