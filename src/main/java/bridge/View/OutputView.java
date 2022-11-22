package bridge.View;

import bridge.Controller.BridgeCase;
import bridge.Controller.BridgeDTO;

public class OutputView {

    public void printStart(){
        System.out.println(MessageCase.START.getMessage() + "\n");
    }
    public void printAskBridgeLength() {
        System.out.println(MessageCase.BRIDE_SIZE.getMessage());
    }
    public void printAskMovingButton(){
        System.out.println(MessageCase.MOVE.getMessage());
    }
    public void printAskGameRestart(){
        System.out.println(MessageCase.RESTART.getMessage());
    }
    public void printGameCount(int gameCount){
        System.out.println(MessageCase.GAME_TRY.getMessage() + gameCount);
    }

    public void printMap(BridgeDTO bridgeDTO){
        System.out.printf("%s", MessageCase.LEFT_BRACKET.getMessage() + " ");
        printBridge(bridgeDTO.getUpCase(), bridgeDTO.getLength());
        System.out.printf("%s", MessageCase.RIGHT_BRACKET.getMessage() + "\n");
        System.out.printf("%s", MessageCase.LEFT_BRACKET.getMessage() + " ");
        printBridge(bridgeDTO.getDownCase(), bridgeDTO.getLength());
        System.out.printf("%s", MessageCase.RIGHT_BRACKET.getMessage() + "\n\n");
    }
    public void printBridge(BridgeCase[] bridgeCase, int length){
        for(int i = 0; i < length; i++){
            System.out.printf("%s", bridgeCase[i] + " ");
            if(i < length - 1) {
                System.out.printf("%s", MessageCase.DIVISION.getMessage() + " ");
            }
        }
    }
    public void printSuccessResult(BridgeDTO bridgeDTO ){
        System.out.println(MessageCase.RESULT.getMessage());
        printMap(bridgeDTO);
        System.out.println(MessageCase.GAME_SUCCESS.getMessage());
    }
    public void printFailedResult(BridgeDTO bridgeDTO){
        System.out.println(MessageCase.RESULT.getMessage());
        printMap(bridgeDTO);
        System.out.println(MessageCase.GAME_FAILED.getMessage());
    }
    public static void printError(Exception e){
        System.out.println(e.getMessage());
    }
}