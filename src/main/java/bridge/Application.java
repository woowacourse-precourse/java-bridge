package bridge;

import bridge.presentation.GameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController=GameController.getInstance();
        gameController.run();
        gameController.inputBridgeSize();
        gameController.generateBridge();
    }

    private static int move(GameController gameController){
        while (true){
                gameController.inputSelectMove();
                if(gameController.move()==0){
                    gameController.
                }
            }
    }

}
