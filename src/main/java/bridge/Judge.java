package bridge;

import bridge.model.MoveResult;

import java.util.List;

public class Judge {

    String upLine = "";
    String downLine = "";


    public MoveResult checkIsCorrectMoving(List<String> bridge, List<String> userBridge) {
        int compareIndex = userBridge.size() - 1;
        if (bridge.get(compareIndex).equals(userBridge.get(compareIndex))) {
            return MoveResult.CORRECT;
        }
        return MoveResult.NOT_CORRECT;
    }

    public void makeResult(List<String> bridge, List<String> userBridge) {

        upLine = "";
        downLine = "";

        for (int i = 0; i < userBridge.size(); i++) {

            if(i==0){
                upLine += "[ ";
                downLine += "[ ";
            }
            if("U".equals(userBridge.get(i))){
                if(bridge.get(i).equals(userBridge.get(i))){
                    upLine += "O";
                    downLine += " ";
                }
                if(!bridge.get(i).equals(userBridge.get(i))){
                    upLine += "X";
                    downLine += " ";
                }
            }
            if("D".equals(userBridge.get(i))){
                if(bridge.get(i).equals(userBridge.get(i))){
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

            if(i==userBridge.size()-1){
                upLine += " ]";
                downLine += " ]";
            }
        }
    }

    @Override
    public String toString() {
        return upLine + "\n" + downLine;
    }
}
