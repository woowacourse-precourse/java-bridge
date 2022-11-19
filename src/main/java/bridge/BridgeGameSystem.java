package bridge;

public class BridgeGameSystem {
    private static final InputView inputView = new InputView();

    public static int getBridgeSize(){
        try{
            return inputView.readBridgeSize();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }
}
