package bridge.game;

import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

import static bridge.enums.IntEnum.*;
import static bridge.enums.StringEnum.*;
import static bridge.view.OutputView.*;

public class BridgeGameCycle {
    private static final boolean CONTINUE = true;
    private static final boolean FINISH = false;
    private static final InputView inputView = new InputView();
    private int coin = 1;
    private int bridgeLength;
    private int nowState;
    private String finalMap;


    public void play() throws IllegalArgumentException {
        beforeGame();
        brideGamePlay();
        afterGame();
    }

    private void afterGame() {
        printResult(nowState, coin, finalMap);
    }

    private void beforeGame() {
        printGameStart();
        bridgeLength = checkReadBridgeSize();
    }
    private int checkReadBridgeSize(){
        while(CONTINUE){
            try{
                printAskLength();
                return inputView.readBridgeSize();
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
    private int oneTurnCycle(BridgeGame game) {
        printAskMoving();
        String inputMoving = inputView.readMoving();
        int nowState = game.move(inputMoving);
        finalMap = game.nowBridgeStage(nowState);
        printMap(finalMap);
        return nowState;
    }

    private String askInputCommand() {
        printAskCommand();
        return inputView.readGameCommand();
    }

    private boolean loseCycle(BridgeGame game) {
        if (nowState == GAME_LOSE.num()) {
            String inputCommand = checkInputCommand();
            if (inputCommand.equals(QUIT.key())) {
                return FINISH;
            }
            coin++;
            game.retry();
        }
        return CONTINUE;
    }

    private String checkInputCommand() {
        while(CONTINUE){
            try{
                return  askInputCommand();
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    private void brideGamePlay() {
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeLength);
        BridgeGame game = new BridgeGame(bridge);
        while (CONTINUE) {
            nowState = oneTurnCycle(game);
            if (nowState == GAME_WIN.num()) break;
            if (!loseCycle(game)) break;
        }
    }
}
