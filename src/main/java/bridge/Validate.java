package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Validate {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;


    public static int validreadBridgeSize(String bridgeSize){
        int bridgeSizeInt=0;
        bridgeSizeInt = Integer.parseInt(bridgeSize);
        if(bridgeSizeInt<MIN_SIZE||bridgeSizeInt>MAX_SIZE){
                throw new IllegalArgumentException();
            }
        return bridgeSizeInt;
    }

}
