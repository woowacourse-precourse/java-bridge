package bridge;

import bridge.presentation.GameController;

public class Application {
    private static final int FAIL=0;
    private static final int FINISH=2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = GameController.getInstance();
            gameController.run();
            gameController.inputBridgeSize();
            gameController.generateBridge();
            move(gameController);
            gameController.exit();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void move(GameController gameController){
        while (true){
            if(!checkMove(gameController)){
                break;
            }
        }
    }
    private static Boolean checkMove(GameController gameController){
        gameController.inputSelectMove();
        int moveValue=gameController.move();
        if(moveValue==FAIL){
            return retry(gameController);
        }
        return moveValue != FINISH;
    }

    private static Boolean retry(GameController gameController){
        if(gameController.inputRetry()){
            move(gameController);
            return false;
        }
        return false;
    }

}
