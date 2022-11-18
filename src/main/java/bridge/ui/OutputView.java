package bridge.ui;

public class OutputView {

    public void printMap(String upperSide, String downSide) {
        System.out.println(upperSide);
        System.out.println(downSide);
    }


    public void printResult(String isSuccess, String totalTry) {
        System.out.println(isSuccess);
        System.out.print(totalTry);
    }
}
