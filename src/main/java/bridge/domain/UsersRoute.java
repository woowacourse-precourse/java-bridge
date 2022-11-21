package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UsersRoute {
    private List<String> route;

    public UsersRoute() {
        this.route = new ArrayList<>();
    }

    public void put(String direction) {
        this.route.add(direction);
    }
}
