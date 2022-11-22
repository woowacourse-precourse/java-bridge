package bridge;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR] ";
    public static void main(String[] args) {
        OutputView.printStart();
        try {
            int size = InputView.readBridgeSize();
            BridgeGame bridgeGame = new BridgeGame(size);
            while(bridgeGame.reTry == true) {
                bridgeGame.move(size);
                if(bridgeGame.finish == true)
                    break;
                bridgeGame.retry();
            }
            OutputView.printResult(bridgeGame.result, bridgeGame.retryCount, bridgeGame.goAlright);
        }catch (IllegalStateException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }
}
