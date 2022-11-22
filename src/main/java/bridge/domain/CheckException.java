package bridge.domain;

import bridge.view.ErrorMessage;

public class CheckException {
    ErrorMessage errorMessage;

    public boolean checkBridgeSize(int size){
        try{
            if(size > 20 || size < 3){
                throw new IllegalArgumentException();
            }
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(errorMessage.ERROR_MESSAGE_SIZE_OUT_OF_RANGE.getMessage());
            return false;
        }
    }

    public boolean checkInputMoving(String moving){
        try {
            if(!moving.equals("U") && !moving.equals("D")){
                throw  new IllegalArgumentException();
            }
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(errorMessage.ERROR_MESSAGE_INPUT_MOVING_NOT_VALID.getMessage());
            return false;
        }
    }

    public boolean checkInputRetryChoice(String retryChoice){
        try {
            if(!retryChoice.equals("R") && !retryChoice.equals("Q")){
                throw  new IllegalArgumentException();
            }
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(errorMessage.ERROR_MESSAGE_INPUT_RETRY_CHOICE_NOT_VALID.getMessage());
            return false;
        }
    }
}
