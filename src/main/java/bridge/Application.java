package bridge;

import bridge.game.BridgeGameCycle;

public class Application {

    public static void main(String[] args) {
        try{
            new BridgeGameCycle().play();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
