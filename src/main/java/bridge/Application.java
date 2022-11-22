package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static boolean isCorrect;
    private static boolean allCorrect = false;
    private static boolean gameCommand = true;

    public static void main(String[] args) {
        startGame();
        while (gameCommand && !allCorrect) {
            moving();
            outputView.printMap();
            checkGaming();
        }
        outputView.printResult();
    }

    public static void checkGaming(){
        while(true){
            try {
                checkGame();
                return ;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void checkGame(){
        if (!isCorrect) {
            gameCommand = inputView.readGameCommand();
        } if (isCorrect){
            allCorrect = inputView.checkAllCorrect();
        }
    }

    public static void startGame(){
        while(true) {
            try {
                inputView.readBridgeSize();
                return ;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    public static void moving(){
        while (true) {
            try {
                isCorrect = inputView.readMoving();
                return ;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

}
