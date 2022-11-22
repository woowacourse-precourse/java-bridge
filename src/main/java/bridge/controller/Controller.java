package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.domain.constants.Command;
import bridge.domain.constants.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.text.OutputText;

public class Controller {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    public Controller (BridgeMaker bridgeMaker, InputView inputView, OutputView outputView){
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 게임을 실행
     */
    public void run(){
        startGame();
        inputBridgeLength();
        while (bridgeGame.getGameState() == GameState.RUNNING){
            move();
            if (bridgeGame.getGameState() == GameState.PAUSE) {
                retry();
            }
        }
        showResult();
    }

    /**
     * 게임을 시작
     */
    private void startGame(){
        outputView.printGameStart();
        this.bridgeGame = new BridgeGame();
    }

    /**
     * 다리 길이를 입력
     */
    private void inputBridgeLength(){
        try {
            outputView.printBridgeLengthInputRequest();
            bridgeGame.setBridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            showMap();
        }
        catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            inputBridgeLength();
        }
    }

    /**
     * 이동
     */
    private void move(){
        try {
            outputView.printMoveInputRequest(Command.MOVE_UP.getCommand(), Command.MOVE_DOWN.getCommand());
            bridgeGame.move(inputView.readMoving());
        }
        catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            move();
        }
    }

    /**
     * 재시도 및 종료
     */
    private void retry(){
        try {
            outputView.printRetryInputRequest(Command.RETRY.getCommand(), Command.QUIT.getCommand());
            bridgeGame.retry(inputView.readGameCommand());
        }
        catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            retry();
        }
    }

    /**
     * 결과 출력
     */
    private void showResult(){
        outputView.printResult(gameStateToString(bridgeGame.getGameState()), bridgeGame.getTrialCount());
        showMap();
    }

    /**
     *
     * @param gameState 게임의 상태
     * @return 상태에 해당하는 문자열
     */
    private String gameStateToString(GameState gameState){
        if (gameState == GameState.CLEAR) return OutputText.STATE_CLEAR.getMessage();
        if (gameState == GameState.FAIL) return OutputText.STATE_FAIL.getMessage();
        return OutputText.STATE_NONE.getMessage();
    }

    /**
     * 현재 진행 상황의 지도를 출력
     */
    private void showMap(){
        outputView.printMap(bridgeGame.getProgress().getUpperBlocks(), bridgeGame.getProgress().getLowerBlocks());
    }
}
