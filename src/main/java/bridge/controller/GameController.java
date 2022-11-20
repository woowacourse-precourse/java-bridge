package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeSpace;
import bridge.model.Moved;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;

public class GameController {
    InputView inputView = new InputView();
    OutputView  outputView = new OutputView();
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;
    Bridge bridge;

    public GameController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridgeGame = new BridgeGame();
    }

    public void playGame() {
        int tryCount = 0;
        informStart();
        buildBridge();
        tryCount = doRepeatBridgeGame();
        printResult(tryCount,bridge);
    }

    private int doRepeatBridgeGame() {
        int tryCount = 0;
        do {
            tryCount += 1;
            bridge = bridgeGame.retry(bridge); // (재시도)초기화 처리
            if (doRepeatBridgeMove()) {
                break;
            }
        }while(askRetry());
        return tryCount;
    }

    private void printResult(int tryCount, Bridge bridge) {
        outputView.printResult(tryCount,bridge);
    }

    private void informStart() {
        outputView.printStartGame();
    }

    private Integer inputBridgeSize() {
        Integer bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    private void buildBridge() {
        Integer bridgeSize = inputBridgeSize();
        List<String> bridgeStrs =  bridgeMaker.makeBridge(bridgeSize);
        bridge = new Bridge(bridgeStrs);
    }

    private String inputUserMove() {
        String userMove = inputView.readMoving();
        return userMove;
    }

    private boolean doRepeatBridgeMove() {
        for (int idx = 0; idx < bridge.getBridgeSpaces().size(); idx++) {
            String userMove = inputUserMove();
            BridgeSpace movedSpace = this.bridgeGame.move(userMove,bridge.getBridgeSpaces().get(idx));
            bridge.getBridgeSpaces().set(idx,movedSpace);
            printNowBridge();
            if(bridge.getBridgeSpaces().get(idx).getMyMoved() == Moved.CANT) break;
        }
        return checkAllDone(); //모두 완료
    }

    private boolean askRetry() {
        // 재시도 묻기
        String retryFlag = inputView.readGameCommand();
        return Objects.equals(retryFlag, "R");
    }

    private boolean checkAllDone() {
        // 모두 완료했는지 검사, 마지막 요소가 이동 가능이면
        return bridge.getBridgeSpaces().get(bridge.getBridgeSpaces().size() - 1).getMyMoved()
                == Moved.CAN;
    }

    private void printNowBridge() {
        outputView.printMap(this.bridge);
    }





}
