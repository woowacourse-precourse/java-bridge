package bridge.service;

import static bridge.domain.GameRetry.Q;
import static bridge.domain.GameRetry.R;
import static bridge.domain.MoveDirection.D;
import static bridge.domain.MoveDirection.U;
import static bridge.domain.BridgeLength.MAX;
import static bridge.domain.BridgeLength.MIN;

public class InputValidation {

    public boolean isNumber(String bridgeLength){
        try {
            stringToInt(bridgeLength);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public boolean isValidRange(int bridgeLength) {
        try {
            if (bridgeLength < MIN.bridgeLength || bridgeLength > MAX.bridgeLength)
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public boolean isValidDirection(String moveDirection){
        try{
            if(!U.strMoveDirection.equals(moveDirection) && !D.strMoveDirection.equals(moveDirection))
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public boolean isValidGameRetryInput(String gameRetryInput){
        try{
            if(!R.command.equals(gameRetryInput) && !Q.command.equals(gameRetryInput))
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public void stringToInt(String bridgeLength){
        try {
            Integer.parseInt(bridgeLength);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}
