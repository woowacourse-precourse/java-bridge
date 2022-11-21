package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    InputView inputView = new InputView();
    BridgeSize bridgeSize = new BridgeSize();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        String reply;
        OutputView.printGameStart();
        do {
            int size = inputSize();
            List<String> bridge = bridgeMaker.makeBridge(size);

            reply = play(bridge);

        }while(!reply.equals("Q"));
    }

    public int inputSize(){
        String size = inputView.readBridgeSize();
        bridgeSize.checkNumber(size);
        return Integer.parseInt(size);
    }

    public void printResult(String fail, int attempt) {
        OutputView.printResult(bridgeGame.toString());
        OutputView.printSuccessOrFail(fail);
        OutputView.printAttemptCount(attempt);

    }

    public String crossBridge(List<String> bridge) {
        for(int i=0;i<bridge.size();i++) {
            String move = inputView.readMoving();
            List<List<String>> bridges = bridgeGame.move(bridge.get(i),move);
            OutputView.printMap(bridgeGame.toString());
            if(endGame(bridges).equals("실패")) {
                return "실패";
            }
        }
        return "성공";
    }

    public String crossingBridge(List<String> bridge){
        reset();
        return crossBridge(bridge);
    }

    public String play(List<String> bridge){
        int attempt = 0;
        String fail;
        String reply = "R";
        do{
            fail = crossingBridge(bridge);
            attempt = bridgeGame.retry(reply, attempt);
            reply = replyQuit(fail);

        }while (!reply.equals("Q"));
        printResult(fail, attempt);
        return reply;
    }

    public String endGame(List<List<String>> bridges){
        int last = bridges.get(0).size() -1;
        List<String> bridgeUp = bridges.get(0);
        List<String> bridgeDown = bridges.get(1);

        if(bridgeUp.get(last).contains("X") || bridgeDown.get(last).contains("X")){
            return "실패";
        }
        return "성공";


    }


//    public void reply(String result) {
//        if(result.contains("X")) {
//            reset();
//            sf = "실패";
//        }
//    }

    public String replyQuit(String fail){
        String reply;
        if(fail.equals("실패")) {
            reply = InputView.readGameCommand();
            return reply;
        }
        return "Q";
    }





    public void reset() {
        bridgeGame.reset();

    }



}
