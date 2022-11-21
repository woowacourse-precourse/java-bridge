package bridge.dto;

import bridge.global.BridgeMessage;

import static bridge.global.BridgeMessage.*;

public class CorrectInfo {
    private BridgeMessage bridgeBlock;
    private BridgeMessage upOrDown;

    private CorrectInfo(BridgeMessage bridge, BridgeMessage upOrDown) {
        this.bridgeBlock = bridge;
        this.upOrDown = upOrDown;
    }

    public static CorrectInfo createCorrectInfo(String blockInput, String userInput){
        BridgeMessage blockStatus = makeBridgeStatus(blockInput);
        BridgeMessage userStatus = makeBridgeStatus(userInput);

        return new CorrectInfo(blockStatus, userStatus);
    }

    private static BridgeMessage makeBridgeStatus(String input) {
        if(input.equals(DOWN.getMessage())){
           return DOWN;
        }
        return UP;
    }

    public boolean isPass(){
        return bridgeBlock.equals(upOrDown);
    }

    public BridgeMessage getBridgeBlock() {
        return bridgeBlock;
    }

    public boolean isFail() {
        return !(bridgeBlock.equals(upOrDown));
    }
}
