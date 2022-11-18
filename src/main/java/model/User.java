package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userMap;

    public User(){
        userMap = new ArrayList<>();
    }

    public void markPosition(String position){
        userMap.add(position);
    }

    public List<String> getUserMap() {
        return userMap;
    }

    public int getUserMovingDistance(){
        return userMap.size();
    }
}
