package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.model.MapShape;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.util.Constant.*;

public class GameController {

    //변수
    private static boolean keepGoing = true;
    private static int currentPosition = 0;
    private static int tryCount = 1;
    private static int bridgeSize;
    private static List<String> bridge;

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private static MapShape mapShape;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        mapShape = new MapShape();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    // 게임 시작
    public void gameStart(){
        inputView.printStartMessage();
        setGame();
        while(keepGoing && currentPosition < bridgeSize){
            playBridgeGame();
        }
        outputView.printResult(tryCount, keepGoing);
    }

    // 게임 세팅
    private void setGame() {
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    // 브릿지 게임
    private void playBridgeGame() {
        String nextMove = inputView.readMoving();
        String moveResult = bridgeGame.move(bridge.get(currentPosition), nextMove);
        outputView.printMap(nextMove, moveResult);
        currentPosition++;
        if(moveResult.equals(FAIL_SIGN)) {
            String retryCommand = inputView.readGameCommand();
            bridgeGame.retry(retryCommand);
        }
    }

    // 게임 리셋
    public static void resetGame() {
        currentPosition = 0;
        tryCount++;
        mapShape.clearMap();
    }

    // 게임 종료
    public static void quitGame() {
        keepGoing = false;
    }

    // 전체 게임 초기화
    public void resetTotalGame(){
        tryCount = 1;
        currentPosition = 0;
        keepGoing = true;
        bridgeMaker.clearBridge();
        mapShape.clearMap();
    }
}
