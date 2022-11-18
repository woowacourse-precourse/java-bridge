package bridge.domain;

import bridge.view.ExceptionMessage;

public class Move {

    public boolean isProper(String str) {
        if(!(str.equals("U") || str.equals("D"))){
            throw new IllegalArgumentException(ExceptionMessage.isProperMsg());
        }
        return true;
    }
}
