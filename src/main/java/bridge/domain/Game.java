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
    public Game(List<String> bridge, int bridgeSize){
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.mapString = new MapString();
        this.bridge = bridge;
        this.bridgeSize= bridgeSize;
        MapString.downstairs = "";
        MapString.upstairs = "";
    }

    public void Start(){
        boolean move = true;
        while (move){
            String readMove = inputView.readMoving();
            move = bridgeGame.move(bridge, readMove);
            List<String> mapStr = bridgeGame.makeMap(readMove, move);
            outputView.printMap(mapStr);
            bridgeGame.index++;
            if (bridgeGame.index == bridgeSize) {
                break ;
            }
        }
        if (move){
            outputView.printResult(SUCCESS, mapString.makeMapString(MapString.upstairs, MapString.downstairs));
            return ;
        }
        String retry = inputView.readGameCommand();
        if (retry.equals("Q")){
            outputView.printResult(FAILURE, mapString.makeMapString(MapString.upstairs, MapString.downstairs));
            return ;
        }
        bridgeGame.retry(bridge, bridgeSize);
    }
}
