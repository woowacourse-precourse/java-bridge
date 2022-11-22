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
        if(this.checker.equals(userUpDown)){
            lowerStatus.add(checkedStatus);
            return;
        };
        lowerStatus.add(" ");
    }
    public String printBridge(){
        final String joinLowerBridge = String.join(" | ",lowerStatus);
        return joinLowerBridge;
    }
}
