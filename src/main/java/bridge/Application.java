package bridge;

import Controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeController bridgeController = new BridgeController();
            String result ="";
            do{
                result = bridgeController.playGame();
            }while (!result.equals("Q"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
