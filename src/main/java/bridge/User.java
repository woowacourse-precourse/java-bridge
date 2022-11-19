package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userBridge = new ArrayList<>();

    public void init(){
        userBridge = new ArrayList<>();
    }

    public void setUserBridge(String userInput){
        userBridge.add(userInput);
    }

    public List<String> getUserBridge(){
        return userBridge;
    }


}
