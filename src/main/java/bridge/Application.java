package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static boolean isCorrect;
    private static boolean allCorrect = false;
    private static boolean gameCommand = true;

    // 다 맞춘경우 while을 끝냄
    // q를 입력한 경우 while을 끝냄
    public static void main(String[] args) {
        inputView.readBridgeSize();
        while (gameCommand || !allCorrect) {
            isCorrect = inputView.readMoving();
            outputView.printMap();
            checkGame();
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
