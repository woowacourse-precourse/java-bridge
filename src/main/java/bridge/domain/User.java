package bridge.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    ArrayList<String> moveLog = new ArrayList<>();

    public void addNext(String moving){
        moveLog.add(moving);
    }

    public ArrayList<String> getMove(){
        return this.moveLog;
    }

    public void clearLog(){
        this.moveLog = new ArrayList<>();
    }
}
