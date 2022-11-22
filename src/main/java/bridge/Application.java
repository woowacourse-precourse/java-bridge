package bridge;

import java.util.List;

public class Application {

    private static int inputBridgeSize(InputView inputView) {
        int bridgeSize = 0;
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridgeSize;
    }

    private static String inputMove(InputView inputView) {
        String moving = "";
        while (true) {
            try {
                moving = inputView.readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moving;
    }

    private static List<String> makeBridge(InputView inputView){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(inputBridgeSize(inputView));
    }

    private static void playGame(InputView inputView, List<String> bridge){
        BridgeGame bridgeGame;
        while(true) {
            bridgeGame = new BridgeGame(bridge);
            if(bridgeGame.move(inputMove(inputView))){
                inputRetry();
            }
        }
    }

    public static void inputRetry(){

    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> bridge = makeBridge(inputView);

        while(true){
            playGame(inputView, bridge);


        }





    }
}
