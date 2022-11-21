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

        while(true) {
            try {
                inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                continue;
            }
            break;
        }

        while (gameCommand && !allCorrect) {
            while (true) {
                try {
                    isCorrect = inputView.readMoving();
                } catch (IllegalArgumentException e){
                    continue;
                }
                break;
            }

            outputView.printMap();
            while(true){
                try {
                    checkGame();
                } catch (IllegalArgumentException e){
                    continue;
                }
                break;
            }

        }
        outputView.printResult();
    }

    public static void checkGame(){
        if (!isCorrect) {
            gameCommand = inputView.readGameCommand();
        } if (isCorrect){
            allCorrect = inputView.checkAllCorrect();
        }
    }
}
