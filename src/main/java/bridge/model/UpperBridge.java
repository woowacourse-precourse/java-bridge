package bridge.model;

import java.util.ArrayList;

import static bridge.Application.bridgeLength;

public class UpperBridge extends GeneralBridge{
    public static ArrayList<String> upperStatus;
    public UpperBridge(String checker){
        this.setChecker(checker);
        upperStatus = new ArrayList<>(bridgeLength);
    }
    public void manageInput(String userUpDown, String checkedStatus){

        if(this.checker.equals(userUpDown)){
            upperStatus.add(checkedStatus);
            return;
        };
        upperStatus.add(" ");
    }
}
