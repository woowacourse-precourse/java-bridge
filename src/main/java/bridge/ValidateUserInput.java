package bridge;

public class ValidateUserInput {
    public void checkBridgeLength(String bridgeLength){
        for(int i = 0; i < bridgeLength.length(); i++){
            if(!Character.isDigit(bridgeLength.charAt(i)))
                throw new IllegalArgumentException("[ERROR]");
        }
        if(Integer.parseInt(bridgeLength) < 3 || Integer.parseInt(bridgeLength) > 20)
            throw new IllegalArgumentException("[ERROR]");
    }

    public void checkReadMoving(String moveButton){
//        if(moveButton.length() > 1)
//            throw new IllegalArgumentException("[ERROR]");
        if(moveButton.equals("U") || moveButton.equals("D"))
            return ;
        throw new IllegalArgumentException("[ERROR]");
    }
}
