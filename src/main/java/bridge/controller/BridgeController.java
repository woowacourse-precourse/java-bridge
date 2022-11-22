package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeSize;
import bridge.util.BridgeUtil;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

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
        }while(!reply.equals(BridgeUtil.QUIT));
    }

    public List<String> makeBridge(){
        int size = bridgeSize.checkNumber(InputView.readBridgeSize());
        return bridgeMaker.makeBridge(size);
    }

    public String play(List<String> bridge){
        int attempt = 0;
        String successStatus;
        String reply = BridgeUtil.RESTART;
        do{
            successStatus = resetBridge(bridge);
            attempt = bridgeGame.retry(reply, attempt);
            reply = replyQuit(successStatus);
        }while (!reply.equals(BridgeUtil.QUIT));
        printResult(successStatus, attempt);
        return reply;
    }

    public String resetBridge(List<String> bridge){
        bridgeGame.reset();
        return crossBridge(bridge);
    }

    public String crossBridge(List<String> bridge) {
        for (String s : bridge) {
            String move = InputView.readMoving();
            List<List<String>> bridges = bridgeGame.move(s, move);
            OutputView.printMap(bridgeGame.toString());
            if (endGame(bridges).equals(BridgeUtil.FAIL)) {
                return BridgeUtil.FAIL;
            }
        }
        return BridgeUtil.SUCCESS;
    }


    public String endGame(List<List<String>> bridges){
        List<String> bridgeUp = bridges.get(0);
        List<String> bridgeDown = bridges.get(1);

        if(bridgeUp.contains(BridgeUtil.WRONG) || bridgeDown.contains(BridgeUtil.WRONG)){
            return BridgeUtil.FAIL;
        }
        return BridgeUtil.SUCCESS;
    }

    public String replyQuit(String successStatus){
        String reply;
        if(successStatus.equals(BridgeUtil.FAIL)) {
            reply = InputView.readGameCommand();
            return reply;
        }
        return BridgeUtil.QUIT;
    }

    public void printResult(String successStatus, int attempt) {
        OutputView.printResult(bridgeGame.toString());
        OutputView.printSuccessOrFail(successStatus);
        OutputView.printAttemptCount(attempt);
    }
}
