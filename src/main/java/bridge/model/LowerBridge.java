package bridge.model;

import java.util.ArrayList;

import static bridge.Application.bridgeLength;

public class LowerBridge extends GeneralBridge{
    public static ArrayList<String> lowerStatus;
    public LowerBridge(String checker){
        this.setChecker(checker);
        lowerStatus = new ArrayList<>(bridgeLength);
    }
    public void manageInput(String userUpDown, String checkedStatus){
        if(this.checker.equals(userUpDown)){
            lowerStatus.add(checkedStatus);
            return;
        };
        lowerStatus.add(" ");
    }
}
