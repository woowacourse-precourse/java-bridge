package bridge.domain;

import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

public class Game {
    public static int gameCount;
    private final int SUCCESS = 1;
    private final int FAILURE = 0;
    private final int BRIDGE_SIZE;
    private final List<String> BRIDGE;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private InputView inputView;
    private MapString mapString;
    private boolean move;
    public Game(List<String> bridge, int bridgeSize){
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame(0);
        this.inputView = new InputView();
        this.mapString = new MapString("","");
        this.BRIDGE = bridge;
        this.BRIDGE_SIZE= bridgeSize;
        this.move = true;
        this.gameCount += 1;
    }

    public void start(){
        while (this.move){
            if (oneMove() == BRIDGE_SIZE) {
                break ;
            }
        }
        if (this.move){
            outputView.printResult(SUCCESS, mapString);
            return ;
        }
        routineWhenFail();
    }

    private int oneMove(){
        String readMove = inputView.readMoving();
        this.move = bridgeGame.move(BRIDGE, readMove);
        outputView.printMap(bridgeGame.makeMap(readMove, this.move, mapString));
        return (bridgeGame.getIndex());
    }

    private void routineWhenFail(){
        String retry = inputView.readGameCommand();
        if (retry.equals("Q")){
            outputView.printResult(FAILURE, mapString);
            return ;
        }
        bridgeGame.retry(BRIDGE, BRIDGE_SIZE);
    }
}
