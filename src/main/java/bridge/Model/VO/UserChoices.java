package bridge.Model.VO;

import java.util.ArrayList;
import java.util.List;

public class UserChoices {
    List<UserChoice> userChoices;

    public UserChoices(){
        this.userChoices = new ArrayList<>();
    }

    public void add(UserChoice userChoice){
        userChoices.add(userChoice);
    }

    public int length(){
        return userChoices.size();
    }

    public UserChoice get(int position){
        return userChoices.get(position);
    }
}
