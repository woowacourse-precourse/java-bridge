package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.ViewMessage;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    /* 상수 및 클래스 변수 */
    private final int GAME_TRY_NUMBER = 1;
    private final int GAME_SUCCESS_OR_FAIL_NUMBER = 0;
    private ViewMessage viewMessage = null;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private BridgeGame bridgeGame = new BridgeGame();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<String> bridge;
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();
    private List<String> resultGame = new ArrayList<>();

    /* 인스턴스 변수 */
    private int bridgeSize = 0;
    private int stage = 0;
    private int tryNumber = 1;

    public void init() {
        outputView.printGameStart();
        System.out.println();
        bridgeSize = inputView.readBridgeSize();
        System.out.println();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public void addBridgeMove(String direction) {
        if (direction.equals("U")) {
            addUpMove(bridgeGame.move(bridge, direction, stage));
            return;
        }
        addDownMove(bridgeGame.move(bridge, direction, stage));
    }

    public void addUpMove(String move) {
        if (move.equals(" O ")) {
            upBridge.add(" O ");
            downBridge.add("   ");
            return;
        }
        upBridge.add(" X ");
        downBridge.add("   ");
    }

    public void addDownMove(String move) {
        if (move.equals(" O ")) {
            downBridge.add(" O ");
            upBridge.add("   ");
            return;
        }
        downBridge.add(" X ");
        upBridge.add("   ");
    }

    public void runGame(){
        stage++;
        addBridgeMove(inputView.readMoving());
        outputView.printMap(upBridge,downBridge);
        System.out.println();
    }

    public boolean checkFail(int stage){
        if(upBridge.get(stage - 1).equals(" X ") || downBridge.get(stage - 1).equals(" X ")){
            return true;
        }
        return false;
    }

    public void startGame(){
        while(stage < bridgeSize){
            runGame();
            if(checkFail(stage)){
                if(quitRetry()){
                    return;
                }
                clearGame();
            }
        }
        addFinishGameResult();
    }

    public void clearGame(){
        stage = 0;
        tryNumber++;
        upBridge.clear();
        downBridge.clear();
    }


    public boolean quitRetry(){
        if(!bridgeGame.retry(inputView.readGameCommand())){
            resultGame.add(viewMessage.RESULT_GAME_FAIL_MESSAGE.getMessage());
            resultGame.add((String.valueOf(tryNumber)));
            return true;
        }
        return false;
    }

    public void addFinishGameResult(){
        resultGame.add(viewMessage.RESULT_GAME_SUCCESS_MESSAGE.getMessage());
        resultGame.add((String.valueOf(tryNumber)));
    }

    public void endGame(){
        System.out.println(viewMessage.RESULT_GAME_MESSAGE.getMessage());
        outputView.printMap(upBridge,downBridge);
        System.out.println();
        outputView.printResult(resultGame.get(GAME_SUCCESS_OR_FAIL_NUMBER), resultGame.get(GAME_TRY_NUMBER));
    }
}
