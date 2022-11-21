package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.utils.constant.Constants.*;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private int tryCount;

    public BridgeGameController() {
        OutputView.printGameStart();
        int bridgeSize = InputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        initTryCount();
    }

    public void initTryCount() {
        tryCount = INIT_VALUE;
    }

    public static void startBridgeGame() {
        // TODO:
        //  다리 길이 입력 받기
        //  다리 길이 유효성 검증
        //  다리 생성
        //  게임 시작
    }

}
