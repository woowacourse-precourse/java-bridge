package bridge.util;

import bridge.constant.ERROR;

public class Validate {

    private static final int MIN_RANGE=3;
    private static final int MAX_RANGE=20;

    public void validateBridgeSize(String size){
        try{
            int sizeInt = Integer.parseInt(size);
            isSizeInRange(sizeInt);
        }
        catch(Exception e){
            throw new IllegalArgumentException(ERROR.sizeException.getException());
        }
    }

    private void isSizeInRange(int sizeInt) {
        if(!(sizeInt >=MIN_RANGE && sizeInt <=MAX_RANGE)){
            throw new IllegalArgumentException();
        }
    }
}
