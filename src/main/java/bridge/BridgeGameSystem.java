package bridge;

public class BridgeGameSystem {
    private static final InputView inputView = new InputView();

    public void startBridgeGame(){
        startGame();
        int bridgeSize = getBridgeSize();
    }

    public static void startGame(){
        inputView.printStartMessage();
    }
    public static int getBridgeSize(){
        try{
            return inputView.readBridgeSize();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }
}
