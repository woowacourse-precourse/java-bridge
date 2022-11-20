package bridge.controller;// @ author ninaaano

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.MapMaker;
import bridge.view.*;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private List<String> bridge = new ArrayList<>();
    BridgeGame bridgeGame;
    MapMaker mapMaker;
    private int count = 0;
    private boolean gameResult = true;

    public BridgeGameController() {
        try {
            OutputView.showStartMessage(); // 1. 게임 시작 메세지 출력 완료
            createBridge();
            moveBridge();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage()); // 수정 필요
        }
    }

    private void bridgeGameSet() {
        bridgeGame = new BridgeGame(bridge);
    }

    private void createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        OutputView.showInputBridgeLength(); // 2. 다리 길이 입력해주세요까지 출력
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize()); // 3. 길이 입력받고 종료함...
        System.out.println();
    }

    private void moveBridge() {
        mapMaker = new MapMaker();

        while (count < bridge.size()) {
            OutputView.showInputMove(); // 이동할 칸 선택
            mapMaker.printMap(); // 맵을 보여준다
            count++; // 움직인다

        }
    }
}
