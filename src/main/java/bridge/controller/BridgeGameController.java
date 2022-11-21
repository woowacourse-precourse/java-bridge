package bridge.controller;

import bridge.InputView;
import bridge.OutputView;
import bridge.data.BridgeResultData;
import bridge.domain.BridgeGame;
import bridge.domain.Moving;

public class BridgeGameController {
    private int trial = 0;
    private boolean isRestart = true;
    private Moving moving;
    private BridgeGame bridgeGame;

    public void run(){
        init();
        while(isRestart){
            move();
        }
    }

    /**
     * 다리 건너기 게임 초기화
     */
    private void init(){
        OutputView.printStart();
        initTrial();
        makeBridge();
    }

    private void initTrial(){
        trial += 1;
    }

    private void makeBridge(){
        try {
            int size = InputView.readBridgeSize();
            bridgeGame = new BridgeGame(size);

        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
            makeBridge();
        }
    }

    /**
     * 다리 건너기
     */
    private void move(){
        readMoving();
        bridgeGame.move(moving);
        OutputView.printMap(BridgeResultData.getBridgeUpResults(), BridgeResultData.getBridgeDownResults());
    }

    private void readMoving(){
        try {
            String movingValue = InputView.readMoving();
            moving = new Moving(movingValue);
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
            readMoving();
        }
    }
}
