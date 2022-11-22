package bridge;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final Progress progress = new Progress();

    public static void main(String[] args) {
        int count = 1;

        outputView.startGameMessage();
        progress.makeBridge();
        while (progress.game()) {
            count++;
        }
        progress.printResult(count);
    }

}
