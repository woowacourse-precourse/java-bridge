package bridge.domain;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

public class Game {
    int SUCCESS = 1;
    int FAILURE = 0;

    public void Start(List<String> bridge, int bridgeSize){
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
        MapString mapString = new MapString();
        MapString.downstairs = "";
        MapString.upstairs = "";
        while (true){
            String readMove = inputView.readMoving();
            boolean move = bridgeGame.move(bridge, readMove);
            List<String> mapStr = bridgeGame.makeMap(readMove, move);
            outputView.printMap(mapStr);
            bridgeGame.index++;
            if (bridgeGame.index == bridgeSize || !move) {
                break ;
            }
        }
        if (bridgeGame.index == bridgeSize){
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
