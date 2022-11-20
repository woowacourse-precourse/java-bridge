package bridge.domain;

import java.util.ArrayList;

public class User {
    ArrayList<String> moveLog;

    public void addNext(String moving){
        moveLog.add(moving);
    }
}
