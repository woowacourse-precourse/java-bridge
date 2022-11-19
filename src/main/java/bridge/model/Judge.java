package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    List<String> bridge;
    List<String> userBridge;


    public Judge(List<String> bridge) {
        this.bridge = bridge;
        this.userBridge = new ArrayList<>();
    }

    public void initUserBridge() {
        userBridge = new ArrayList<>();
    }

    public void addUserBridge(Moving moving) {
        userBridge.add(moving.getValue());
    }

    public MoveResult checkIsCorrectMoving(Moving moving) {
        int compareIndex = userBridge.size() - 1;
        if (bridge.get(compareIndex).equals(moving.getValue())) {
            return MoveResult.CORRECT;
        }
        return MoveResult.NOT_CORRECT;
    }

    public String makeMap() {

        String upLine = "";
        String downLine = "";

        for (int i = 0; i < userBridge.size(); i++) {

            if (i == 0) {
                upLine += "[ ";
                downLine += "[ ";
            }
            if ("U".equals(userBridge.get(i))) {
                if (bridge.get(i).equals(userBridge.get(i))) {
                    upLine += "O";
                    downLine += " ";
                }
                if (!bridge.get(i).equals(userBridge.get(i))) {
                    upLine += "X";
                    downLine += " ";
                }
            }

            if ("D".equals(userBridge.get(i))) {
                if (bridge.get(i).equals(userBridge.get(i))) {
                    upLine += " ";
                    downLine += "O";
                }
                if(!bridge.get(i).equals(userBridge.get(i))){
                    upLine += " ";
                    downLine += "X";
                }
            }

            if(i!=userBridge.size()-1){
                upLine += " | ";
                downLine += " | ";
            }

            if (i == userBridge.size() - 1) {
                upLine += " ]";
                downLine += " ]";
            }
        }

        return upLine + "\n" + downLine;
    }


    public boolean isGameEnd(MoveResult moveResult) {
        return moveResult == MoveResult.CORRECT && userBridge.size() != bridge.size();
    }


}
