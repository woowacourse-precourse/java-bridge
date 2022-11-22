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
}
