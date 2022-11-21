package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.OutputView;
import bridge.view.InputView;
import bridge.domain.Validation;

import java.util.List;

import static bridge.domain.BridgeGame.*;

public class BridgeGameController {
    private static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeGame bridgeGame;
    private String successResult = "";
    private boolean moving = true;

    public void start(){
        OutputView.startMessage();
        inputBridgeSizeAndGenerate();
        inputBridgeMove();
        printGameResult(successResult);
    }

    private void inputBridgeSizeAndGenerate(){
        while (true){
            try {
                bridgeGame = new BridgeGame(generateBridge());
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBridgeMove(){
        while (moving){
            try{
                bridgeMove();
                successResult = successJudgment();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> generateBridge(){
        int bridgeSize = InputView.inputBridgeSize();
        Validation.validateRange(bridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void bridgeMove(){
        String blankToMove = InputView.inputMoving();
        Validation.isValidBlankToMove(blankToMove);
        bridgeGame.move(blankToMove);
        OutputView.printMap(bridgeGame.makeBridgeCrossingResult());
    }

    private String successJudgment(){
        String judgment = bridgeGame.judgment();
        if (judgment.equals(SUCCESS)){
            moving = false;
        } else if (judgment.equals(FAILURE)) {
            inputRetryOrEnd();
        }
        return judgment;
    }

    private void inputRetryOrEnd(){
        while (true){
            try {
                retryOrEnd();
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void retryOrEnd(){
        String command = InputView.inputGameCommand();
        Validation.isValidRetryOrEnd(command);
        if (command.equals("R")){
            bridgeGame.retry();
        } else if (command.equals("Q")) {
            moving = false;
        }
    }

    private void printGameResult(String successResult){
        OutputView.endMessage();
        OutputView.printMap(bridgeGame.makeBridgeCrossingResult());
        OutputView.printResult(successResult, bridgeGame.toString());
    }
}
