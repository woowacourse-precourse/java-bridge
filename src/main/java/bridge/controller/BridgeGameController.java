package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.utils.constant.Constants.*;

public class BridgeGameController {
    private final BridgeGame bridgeGame = new BridgeGame();
    private int tryCount;

    public static void startBridgeGame() {
        OutputView.printGameStart();
        int bridgeSize = InputView.readBridgeSize();
        // TODO:
        //  다리 길이 입력 받기
        //  다리 길이 유효성 검증
        //  다리 생성
        //  게임 시작

    }
}
