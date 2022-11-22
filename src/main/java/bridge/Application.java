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
            List<String> lastMap = new ArrayList<>();
            boolean flag = true;

            for(int i = 0; i < size; i++){
                String moving = inputView.readMoving();
                flag = game.move(moving);
                lastMap = outputView.printMap(game.userMoving, flag);

                if(!flag){
                    if(!inputView.readGameCommand()){
                        break;
                    }
                    game.retry();
                    i = -1;
                }
            }
            outputView.printResult(lastMap, flag, game.getCount());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
