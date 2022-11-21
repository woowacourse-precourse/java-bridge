package bridge;

import java.util.ArrayList;

import static bridge.Application.bridgeLength;

public class LowerBridge extends GeneralBridge{
    static ArrayList<String> lowerStatus;
    LowerBridge(String checker){
        this.setChecker(checker);
        lowerStatus = new ArrayList<>(bridgeLength);
    }
    void manageInput(String userUpDown, String checkedStatus){
        System.out.println("this is user updown"+userUpDown);
        System.out.println("this is checker"+checker);

        if(this.checker.equals(userUpDown)){
            lowerStatus.add(checkedStatus);
            return;
        };
        lowerStatus.add("");
        return;
    }
}
