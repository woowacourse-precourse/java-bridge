package model;

import java.util.List;

import static controller.Util.validateMoving;

public class User {


    private List<String> movingRoute;

    private String currentMoving;

    public User(List<String> movingRoute) {
        this.movingRoute = movingRoute;
    }
    public String getCurrentMoving() {
        return currentMoving;
    }

    public void setCurrentMoving(String currentMoving) {
        validateMoving(currentMoving);
        this.currentMoving = currentMoving;
    }

    public List<String> getMovingRoute() {
        return movingRoute;
    }

    public void addMovingRoute(String moving){
        movingRoute.add(moving);
    }
}
