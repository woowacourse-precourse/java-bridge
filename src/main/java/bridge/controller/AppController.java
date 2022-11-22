package bridge.controller;

import bridge.constant.MessageOutput;
import bridge.util.BridgeCalculator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppController {
    BridgeGame bridgeGame;

    void makeBridge() {
        OutputView.printLine(MessageOutput.INTRO);
        OutputView.printLine("");
        OutputView.printLine(MessageOutput.INQUIRE_BRIDGE_LENGTH);
        int size = InputView.readBridgeSize();
        bridgeGame = new BridgeGame(size);
        OutputView.printLine("");
    }

    void crossOver() {
        boolean aRound = true;
        while(aRound) {
            inOrderCrossOver();
            if(bridgeGame.isSuccess()) break; //성공하면 종료
            if(!inquiryRetry()) break; //다시 시도안하면 종료
            bridgeGame.retry();
        }
    }

    void inOrderCrossOver() {
        boolean movingResult;
        for(int i=0 ; i<bridgeGame.getSize() ; i++) {
            movingResult = tryMoving(i);
            OutputView.printMap(bridgeGame.getBridge(), bridgeGame.getUser());
            if(!movingResult) break; //실패하면 그만
            if(movingResult && (i == bridgeGame.getSize()-1)) bridgeGame.setSuccess(); //성공하고 마지막이면 성공
        }
    }

    boolean tryMoving(int index) {
        OutputView.printLine(MessageOutput.INQUIRE_MOVE_BLOCK);
        String input = InputView.readMoving();
        bridgeGame.move(input);
        boolean isSuccess = BridgeCalculator.compareInputAndResult(input, bridgeGame.getIndexResult(index));
        return isSuccess;
    }

    public boolean inquiryRetry() {
        OutputView.printLine(MessageOutput.INQUIRE_REGAIN_GAME);
        String decision = InputView.readGameCommand();
        boolean isRetry = BridgeCalculator.whetherRetryOrQuit(decision);
        return isRetry;
    }

    void showResult() {
        OutputView.printResult(bridgeGame.getBridge(), bridgeGame.getUser());
    }

    public void run() {
        makeBridge();
        crossOver();
        showResult();
    }
}
