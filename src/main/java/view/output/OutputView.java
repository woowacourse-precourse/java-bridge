package view.output;

public class OutputView {

    public void printStartMessage() {
        OutputMessage.START_MESSAGE.print();
    }

    public void printMap(String bridge) {
        System.out.println(bridge);
    }

    public void printEndMessage() {
        OutputMessage.END_MESSAGE.print();
    }

    public void printResult(int tryCount, String result) {
        OutputMessage.SUCCESS_OR_FAIL.print(); System.out.print(result);
        OutputMessage.TOTAL_NUMBER.print(); System.out.print(tryCount);
    }
}