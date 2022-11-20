package bridge;

public class Application {

    private static BridgeGame bridgeGame;
    private static boolean flag;

    public static void main(String[] args) {
        bridgeGame = new BridgeGame(new InputView(), new OutputView(), new BridgeMaker(new BridgeRandomNumberGenerator()));
        do {
            bridgeGame.init();
            if(bridgeGame.move()){
                break;
            }
            flag = bridgeGame.retry();
        } while(flag);
    }
}
