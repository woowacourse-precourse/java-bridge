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
            printResult();
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
        do {
            bridgeGameSet();
            count++;
        }while (gameProceeding());
    }

    private boolean gameProceeding(){
        mapMaker = new MapMaker(bridge);
        while(true){
            OutputView.showInputMove();
            boolean proceeding = bridgeGame.move(InputView.readMoving());
            mapMaker.addMap(proceeding);
            OutputView.printMap(mapMaker);

            if(!proceeding){ // 여기까진 맞음
                OutputView.showGameStatus();
                return bridgeGame.retry(InputView.readGameCommand());
            }
            if (bridgeGame.isEscape()){
                return gameResult = false;
            }
        }
    }

    private void printResult(){
        OutputView.printResult(mapMaker, gameResult, count);
    }
}
