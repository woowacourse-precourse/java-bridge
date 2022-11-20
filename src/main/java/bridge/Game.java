package bridge;

import java.util.List;

public class Game {
    int SUCCESS = 1;
    int FAILURE = 0;

    public void Start(List<String> bridge, int bridgeSize){
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
        while (true){
            String readMove = inputView.readMoving();
            boolean move = bridgeGame.move(bridge, readMove);
            outputView.printMap(readMove, move);
            bridgeGame.index++;
            if (bridgeGame.index == bridgeSize || !move) {
                break ;
            }
        }
        if (bridgeGame.index == bridgeSize){
            outputView.printResult(SUCCESS);
            return ;
        }
        String retry = inputView.readGameCommand();
        if (retry.equals("Q")){
            outputView.printResult(FAILURE);
            return ;
        }
        bridgeGame.retry(bridge, bridgeSize);
    }
}
