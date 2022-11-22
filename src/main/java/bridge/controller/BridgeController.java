package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeSize;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.util.BridgeUtil.*;

public class BridgeController {
    BridgeGame bridgeGame = new BridgeGame();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeSize bridgeSize = new BridgeSize();

    public void start() {
        String reply;
        OutputView.printGameStart();
        do {
            List<String> bridge = makeBridge();
            reply = play(bridge);
        }while(!reply.equals(QUIT.getValue()));
    }

    public List<String> makeBridge(){
        try {
            int size = bridgeSize.checkNumber(InputView.readBridgeSize());
            return bridgeMaker.makeBridge(size);
        }catch (IllegalArgumentException e) {
            inputError(e);
            return makeBridge();
        }
    }

    public String play(List<String> bridge){
        int attempt = 0;
        String successStatus;
        String reply = RESTART.getValue();
        do{
            successStatus = resetBridge(bridge);
            attempt = bridgeGame.retry(reply, attempt);
            reply = replyQuit(successStatus);
        }while (!reply.equals(QUIT.getValue()));
        printResult(successStatus, attempt);
        return reply;
    }

    public String resetBridge(List<String> bridge){
        bridgeGame.reset();
        return crossBridge(bridge);
    }

    public String crossBridge(List<String> bridge) {
        for (String s : bridge) {
            String move = inputMoving();
            List<List<String>> bridges = bridgeGame.move(s, move);
            OutputView.printMap(bridgeGame.toString());
            if (endGame(bridges).equals(FAIL.getValue())) {
                return FAIL.getValue();
            }
        }
        return SUCCESS.getValue();
    }

    public String inputMoving(){
        try {
            return InputView.readMoving();
        }catch (IllegalArgumentException e){
            inputError(e);
            return inputMoving();
        }
    }


    public String endGame(List<List<String>> bridges){
        List<String> bridgeUp = bridges.get(0);
        List<String> bridgeDown = bridges.get(1);

        if(bridgeUp.contains(WRONG.getValue()) || bridgeDown.contains(WRONG.getValue())){
            return FAIL.getValue();
        }
        return SUCCESS.getValue();
    }

    public String replyQuit(String successStatus){
        if(successStatus.equals(FAIL.getValue())) {
            return inputGameCommand();
        }
        return QUIT.getValue();
    }

    public String inputGameCommand(){
        try{
            return InputView.readGameCommand();
        }catch (IllegalArgumentException e){
            inputError(e);
            return inputGameCommand();
        }
    }

    public void printResult(String successStatus, int attempt) {
        OutputView.printResult(bridgeGame.toString());
        OutputView.printSuccessOrFail(successStatus);
        OutputView.printAttemptCount(attempt);
    }

    public void inputError(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
}
