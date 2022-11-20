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
    private boolean moving = true;

    public void start(){
        OutputView.startMessage();

        while (true){
            try {
                bridgeGame = new BridgeGame(generateBridge());
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String successResult = "";

        while (moving){
            try{
                String blankToMove = inputBridgeMove();
                bridgeMove(blankToMove);
                successResult = successJudgment();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        printGameResult(successResult);
    }

    private List<String> generateBridge(){
        int bridgeSize = InputView.inputBridgeSize();
        Validation.validateRange(bridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private String inputBridgeMove(){
        String blankToMove = InputView.inputMoving();
        Validation.isValidBlankToMove(blankToMove);
        return blankToMove;
    }

    private void bridgeMove(String blankToMove){
        bridgeGame.move(blankToMove);
        OutputView.printMap(bridgeGame.makeBridgeCrossingResult());
    }

    private String successJudgment(){
        String judgment = bridgeGame.judgment();
        if (judgment.equals(SUCCESS)){
            moving = false;
            return SUCCESS;
        } else if (judgment.equals(FAILURE)) {
            inputRetryOrEnd();
            return FAILURE;
        }
        return MOVING;
    }

    private void inputRetryOrEnd(){
        while (true){
            try {
                String command = InputView.inputGameCommand();
                Validation.isValidRetryOrEnd(command);
                retryOrEnd(command);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void retryOrEnd(String command){
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
