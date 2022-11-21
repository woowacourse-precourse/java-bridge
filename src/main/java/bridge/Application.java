package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        BridgeGame bridgeGame = new BridgeGame();
        try{
            bridgeGame.playGame();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
