package bridge;

public class PrintManager {
    private OutputView printer;
    private boolean gameResult;
    private int tryCount;
    Bridge bridge;
    PrintManager(Bridge bridge){
        printer = new OutputView();
        this.bridge=bridge;

    }
    public void printMap(){
        printer.printMap(bridge);
    }
    public void putResult(boolean result, int tryCount){
        gameResult = result;
        this.tryCount=tryCount;
    }
    public void printResult(){
        printer.printResult(bridge, gameResult);
        printer.printTryCount(tryCount);
    }
}
