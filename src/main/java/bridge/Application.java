package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static int size = inputView.readBridgeSize();
    private static List<String> bridge = bridgeMaker.makeBridge(size);

    public static void main(String[] args) {
        try{
            BridgeGame game = new BridgeGame(bridge);
            playGame(game);

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void playGame(BridgeGame game){
        boolean flag = true;

        for(int i = 0; i < size; i++){
            String moving = inputView.readMoving();
            flag = game.move(moving);
            outputView.printMap(game.userMoving, flag);

            if(!flag){
                if(!inputView.readGameCommand()){
                    break;
                }
                game.retry();
                i = -1;
            }
        }
        List<String> lastMap = new ArrayList<>();
    }
}
