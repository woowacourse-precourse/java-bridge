package bridge.controller;

import bridge.InputView;
import bridge.OutputView;
import bridge.data.BridgeResultData;
import bridge.domain.BridgeGame;
import bridge.domain.GameCommand;
import bridge.domain.Moving;

public class BridgeGameController {
    private int trial = 0;
    private boolean isRestart = true;
    private Moving moving;
    private GameCommand gameCommand;
    private BridgeGame bridgeGame;

    public void run(){
        init();
        while(isRestart){
            move();
            if (!bridgeGame.isRightResult(moving.getValue())){
                restartOrQuit();
            }
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

    /**
     * 재시작 여부
     */
    private void restartOrQuit(){
        readGameCommand();
        if (isRestartResult()){
            bridgeGame.retry();
            trial++;
        }
        if (isQuitResult()){
            isRestart = false;
            OutputView.printResult();
        }
    }

    private void readGameCommand(){
        try {
            String gameCommandValue = InputView.readGameCommand();
            gameCommand = new GameCommand(gameCommandValue);
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
            readGameCommand();
        }
    }

    private boolean isRestartResult(){
        String gameCommandValue = gameCommand.getValue();
        return gameCommandValue.equals(GameCommand.getRestartCharacter());
    }

    private boolean isQuitResult(){
        String gameCommandValue = gameCommand.getValue();
        return gameCommandValue.equals(GameCommand.getQuitCharacter());
    }
}
