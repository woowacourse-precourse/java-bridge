package model;

import java.util.List;

public class User {

    private List<String> movingRoute;
    public void setMovingRoute(List<String> movingRoute,String moving) {
        movingRoute.add(moving);
        this.movingRoute = movingRoute;
    }
    public List<String> getMovingRoute() {
        return movingRoute;
    }

}
