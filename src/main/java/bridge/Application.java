package bridge;

import bridge.controller.BridgeController;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        try{
            BridgeController bridgeController = new BridgeController();
            bridgeController.start();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
