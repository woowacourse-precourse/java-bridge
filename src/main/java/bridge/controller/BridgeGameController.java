package bridge.controller;

import bridge.InputView;
import bridge.OutputView;
import bridge.data.BridgeResultData;
import bridge.domain.BridgeGame;
import bridge.domain.GameCommand;
import bridge.domain.Moving;

public class BridgeGameController {
    private static final String SUCCESS_RESULT = "성공";
    private static final String FAIL_RESULT = "실패";

    private int trial = 0;
    private boolean isRestart = true;
    private Moving moving;
    private GameCommand gameCommand;
    private BridgeGame bridgeGame;

    /**
     * 다리 건너기 게임 시작
     * '입력 받은 칸'과 '건널 수 있는 칸' 비교 결과 다를 경우
     * '입력 받은 칸'과 '건널 수 있는 칸' 비교 결과 마지막 칸일 경우
     */
    public void run(){
        init();
        while(isRestart){
            move();
            if (!bridgeGame.isRightResult(moving.getValue())){
                restartOrQuit();
            }

            if (bridgeGame.isSuccess(moving.getValue())){
                isRestart = false;
                OutputView.printResult();
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
     * 재시작 명령어가 R일 경우, 재시작 명령어가 Q일 경우 흐름 분기
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
