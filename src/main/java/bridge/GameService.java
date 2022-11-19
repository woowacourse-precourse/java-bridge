package bridge;

import java.util.List;

public class GameService {
    public void playGame(){
        boolean gameStartOrNot=true;
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printStartString();
        int size=inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> strings = bridgeMaker.makeBridge(size);


        while (gameStartOrNot){
            if(!bridgeGame.move()){
                gameStartOrNot= bridgeGame.retry();
            }else{

            }
        }
    }
}
