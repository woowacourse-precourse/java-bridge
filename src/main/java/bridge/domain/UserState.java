package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserState {
    private boolean quit;
    private int tryCount;
    List<String> upState;
    List<String> downState;

    public UserState() {
        this.quit = false;
        this.tryCount = 1;
        this.upState = new ArrayList<>();
        this.downState = new ArrayList<>();
    }
}
