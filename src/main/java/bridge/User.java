package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userLocation;

    public User(int bridgeSize){
        userLocation = new ArrayList<>(bridgeSize);
    }

    public List<String> getUserLocation(){
        return userLocation;
    }

    public void move(String direction){
        userLocation.add(direction);
    }

    public int getUserCurrentLocation(){
        return userLocation.size() - 1;
    }
}