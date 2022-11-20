package bridge;

import java.util.List;

public class Application {
    private static BridgeGame bridgeGame = new BridgeGame();
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static User user = new User();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.startGame();
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        while(true){
            String direction = inputView.readMoving();
            bridgeGame.move(user);
            boolean checkDirection = bridgeGame.checkBridgeValueInUserPosition(user, direction, bridge);
            outputView.printMap(user.getUserPosition(), direction, checkDirection, bridge);
            if(checkDirection){
                if(bridgeGame.checkGameIsOver(user, direction, size, bridge)){
                    outputView.printResult();
                    break;

                }
            }else{
                if(inputView.readGameCommand() == "R") {
                    bridgeGame.retry(user);
                }else{
                    outputView.printResult();
                    break;
                }
            }

        }
    }
}
