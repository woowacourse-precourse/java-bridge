package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameControl {

    public static void moveAndPrintMap(){
        InputView.readMoving();
        OutputView.printMap();
    }

    public static String retryControl(){
        return InputView.readGameCommand();
    }

    public static void endControl(int attempts){
        OutputView.printResult(CalculationResult.calculateResult(),attempts);
    }
}
