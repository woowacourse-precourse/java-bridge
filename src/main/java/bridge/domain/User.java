package bridge.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    ArrayList<String> moveLog;

    public void addNext(String moving){
        moveLog.add(moving);
    }

    public ArrayList<String> getMove(){
        return this.moveLog;
    }

}
