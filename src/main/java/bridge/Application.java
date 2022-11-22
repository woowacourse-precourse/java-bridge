package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeControl bridgeControl = new BridgeControl();
            bridgeControl.start();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
