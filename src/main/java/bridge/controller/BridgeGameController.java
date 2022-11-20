package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static String bridgeLength;

    public static void execute() {
        //게임 시작 문구 출력하기
        OutputView.printGameStartMessage();
        //다리 길이 입력 기능
        bridgeLength = InputView.readBridgeSize();
        //입력된 다리 길이에 대한 검증 기능
        InputView.validateBridgeLength(bridgeLength);
    }
}
