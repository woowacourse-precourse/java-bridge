package bridge.domain;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

public class Game {
    private final int SUCCESS = 1;
    private final int FAILURE = 0;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private InputView inputView;
    private MapString mapString;
    private List<String> bridge;
    private int bridgeSize;
    private boolean move;
    public Game(List<String> bridge, int bridgeSize){
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.mapString = new MapString();
        this.bridge = bridge;
        this.bridgeSize= bridgeSize;
        MapString.downstairs = "";
        MapString.upstairs = "";
        this.move = true;
    }

    public void start(){
        while (this.move){
            if (oneMove() == bridgeSize) {
                break ;
            }
        }
        if (this.move){
            outputView.printResult(SUCCESS, mapString.makeMapString(MapString.upstairs, MapString.downstairs));
            return ;
        }
        routineWhenFail();
    }

    private int oneMove(){
        String readMove = inputView.readMoving();
        this.move = bridgeGame.move(bridge, readMove);
        outputView.printMap(bridgeGame.makeMap(readMove, this.move));
        bridgeGame.index++;
        return (bridgeGame.index);
    }

    private void routineWhenFail(){
        String retry = inputView.readGameCommand();
        if (retry.equals("Q")){
            outputView.printResult(FAILURE, mapString.makeMapString(MapString.upstairs, MapString.downstairs));
            return ;
        }
        bridgeGame.retry(bridge, bridgeSize);
    }
}
