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

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> bridge = makeBridge(inputView);
        BridgeGame bridgeGame;

        while(true){
            bridgeGame = new BridgeGame();
            bridgeGame.move(inputMove(inputView));
        }





    }
}
