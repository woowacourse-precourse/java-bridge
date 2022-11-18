package bridge;

import camp.nextstep.edu.missionutils.Console;

public class ValidateUserInput {
    public void checkBridgeLength(String bridgeSize){
        for(int i = 0; i < bridgeSize.length(); i++){
            if(!Character.isDigit(bridgeSize.charAt(i))) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
        if(Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20)
            throw new IllegalArgumentException("[ERROR]");
    }
    public void checkReadMoving(String moveButton){
        if(moveButton.equals("U") || moveButton.equals("D")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR]");
    }
    public void checkGameCommand(String gameCommandButton){
        if(gameCommandButton.equals("R") || gameCommandButton.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR]");
    }
}
