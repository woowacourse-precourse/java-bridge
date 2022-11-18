package bridge.ui;

import bridge.model.GameMessage;

public class OutputView {

    public void printMap(String upperSide, String downSide) {
        System.out.println(upperSide);
        System.out.println(downSide);
    }


    public void printResult(String isSuccess, String totalTry) {
        System.out.println(isSuccess);
        System.out.print(totalTry);
    }

    public void printMapResult(String upperSide, String downSide){
        System.out.println(GameMessage.GAME_RESULT.getOutput());
        System.out.println(upperSide);
        System.out.println(downSide);
    }
}
