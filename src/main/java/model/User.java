package model;

import java.util.ArrayList;
import java.util.List;

public class User {


    private List<String> movingRoute;

    private String currentMoving;

    public User() {
        movingRoute = new ArrayList<>();
    }

    public String getCurrentMoving() {
        return currentMoving;
    }

    public void setCurrentMoving(String currentMoving) {
        this.currentMoving = currentMoving;
    }

    public int sizeMovingRoute() {
        return movingRoute.size();

    }

    public void addMovingRoute(String moving) {
        movingRoute.add(moving);
    }

    public void clearUser() {
        movingRoute.clear();
        currentMoving = null;
    }
}
