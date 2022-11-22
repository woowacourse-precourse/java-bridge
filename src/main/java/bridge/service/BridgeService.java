package bridge.service;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.CorrectInfo;
import java.util.List;

import static bridge.global.BridgeMessage.*;
import static bridge.global.ErrorMessage.*;

public class BridgeService {

    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeService() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame();
    }

    public List<String> makeBridge(String length) {
        int len = validateBridgeLength(length);
        return bridgeMaker.makeBridge(len);
    }

    private int validateBridgeLength(String length) {
        if(isNumber(length) == false){
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR.getMessage());
        }
        int len = Integer.parseInt(length);
        if(len < 3 || len > 20){
            throw new IllegalArgumentException(INPUT_BRIDGE_LENGTH_ERROR.getMessage());
        }
        return len;
    }

    private boolean isNumber(String value){
        for(int i=0;i<value.length();i++){
            if(Character.isDigit(value.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }

    public CorrectInfo makeCorrectInfo(String block, String userInput) {
        validateUserMove(userInput);
        CorrectInfo move = bridgeGame.move(block, userInput);
        return move;
    }

    public List<CorrectInfo> initUserInput(){
        return bridgeGame.retry();
    }

    public void validateUserMove(String userInput){
        if(!userInput.equals(UP.getMessage()) &&
                !userInput.equals(DOWN.getMessage())){
            throw new IllegalArgumentException(INPUT_GUESS_BLOCK_ERROR.getMessage());
        }
    }

    public boolean makeContinueMessage(String playContinue) {
        if(!playContinue.equals(RUN.getMessage()) && !playContinue.equals(QUIT.getMessage())){
            throw new IllegalArgumentException(INPUT_RETRY_ERROR.getMessage());
        }
        if(playContinue.equals(RUN.getMessage())){
            return true;
        }
        return false;
    }
}
