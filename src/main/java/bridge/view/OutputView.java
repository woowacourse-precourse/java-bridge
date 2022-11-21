package bridge.view;

public class OutputView {

    public void printMessage(String message)
    {
        System.out.print(message);
    }

    public void printMap(String bridgeMap) {
        printMessage(bridgeMap);
    }

    public void printResult(String gameResult)
    {
        printMessage(gameResult);
    }
}
