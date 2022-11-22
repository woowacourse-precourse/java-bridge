package bridge.controller;

import bridge.InputView;
import bridge.OutputView;
import bridge.data.BridgeResultData;
import bridge.domain.BridgeGame;
import bridge.domain.GameCommand;
import bridge.domain.Moving;

import java.util.List;

public class BridgeGameController {
    private static final String SUCCESS_RESULT = "성공";
    private static final String FAIL_RESULT = "실패";
    private static final int ZERO_TRIAL = 0;

    private int trial = ZERO_TRIAL;
    private boolean isRun = true;
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
        while(isRun){
            move();
            if (!bridgeGame.isRightResult(moving.getValue())){
                restartOrQuit();
                continue;
            }
            validateSuccess();
        }
    }

    private void validateSuccess(){
        if (bridgeGame.isSuccess(moving.getValue())){
            quit(BridgeResultData.getBridgeUpResults(), BridgeResultData.getBridgeDownResults(), SUCCESS_RESULT, trial);
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
        countTrial();
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
     * 재시작 여부 입력
     * 재시작 명령어가 R일 경우, 재시작 명령어가 Q일 경우 흐름 분기
     */
    private void restartOrQuit(){
        readGameCommand();
        if (isRestartResult()){
            restart();
        }
        if (isQuitResult()){
            quit(BridgeResultData.getBridgeUpResults(), BridgeResultData.getBridgeDownResults(), FAIL_RESULT, trial);
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

    private void restart(){
        bridgeGame.retry();
        countTrial();
    }

    private void quit(List<String> bridgeUpResults, List<String> bridgeDownResults, String gameResult, int trial){
        stop();
        OutputView.printResult(bridgeUpResults, bridgeDownResults, gameResult, trial);
    }

    /**
     * 게임 시도 횟수 계산, 게임 종료
     */
    private void countTrial(){
        trial++;
    }

    private void stop(){
        isRun = false;
    }
}