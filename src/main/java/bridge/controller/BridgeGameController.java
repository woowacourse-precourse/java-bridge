package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    public void run () {
        /**
         * 게임 시작 메시지와 Bridge의 길이를 입력 받아 bridgeSize를 저장
         */
        OutputView outputView = new OutputView();
        getBridgeLength(outputView);
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        /**
         * Bridge 정답 배열을 생성해서 bridge 배열에 저장
         */
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        /**
         *
         */
        BridgeGame bridgeGame = new BridgeGame(bridge);
        List<String> userBridge = new ArrayList<>();

        int bridgeIndex = 0;
        while (bridgeIndex < bridgeSize) {
            outputView.printInputMoveMessage();
            String userBridgeType;
            userBridgeType = inputView.readMoving();

            if (bridgeGame.move(bridgeIndex, userBridgeType)) {
                outputView.printMap(bridgeGame.getUserBridge());
                bridgeIndex++;
                continue;
            }

            outputView.printInputRetrialMessage();
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("Q")) {
                //userBridge = bridgeGame.retry();
                break;
            }//Q인경우
            bridgeGame.clear();
            bridgeIndex = 0;

        }

    }

    private void getBridgeLength(OutputView outputView) {
        outputView.printStartMessage();
        outputView.printInputBridgeLengthMessage();
    }

}
