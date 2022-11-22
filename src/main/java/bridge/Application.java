package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try{
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();

            int size = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(size);
            BridgeGame game = new BridgeGame(bridge);

            for(int i = 0; i < size; i++){
                String moving = inputView.readMoving();
                game.putResult(game.move(moving));
                outputView.printMap(game.userMoving, game.getResult());

                if(!game.getResult()){
                    if(!inputView.readGameCommand()){
                        break;
                    }
                    game.retry();
                    i = -1;
                }
            }
            outputView.printResult(game.userMoving, game.result, game.getCount());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
