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

    public static String validateMoving(String moving){
        if((!Objects.equals(moving, BridgeStatus.UP.getValueString()) && !Objects.equals(moving, BridgeStatus.DOWN.getValueString()))){
            throw new IllegalArgumentException();
        }
        return moving;
    }

    public static String validateGameCommand(String gameCommand){
        if((!Objects.equals(gameCommand, BridgeStatus.RETRY.getValueString()) && !Objects.equals(gameCommand, BridgeStatus.QUIT.getValueString()))){
            throw new IllegalArgumentException();
        }
        return gameCommand;
    }

}
