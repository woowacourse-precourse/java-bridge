package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int totalTry;
    private List<String> select;

    public User() {
        this.totalTry = 0;
        this.select = new ArrayList<>();
    }
}
