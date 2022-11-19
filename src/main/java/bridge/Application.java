package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);


        int currentLocation = 0;
        int tryCount = 1;
        while (currentLocation < bridgeSize) {
            String userPath = inputView.readMoving();
            boolean successOrFailure = bridgeGame.move(currentLocation, userPath);
            outputView.printMap(bridgeGame.getPassedPath(), successOrFailure);
            if (successOrFailure == false) {
                String retryOrEnd = inputView.readGameCommand();
                if (retryOrEnd.equals("R")) {
                    tryCount++;
                    currentLocation = 0;
                    bridgeGame.initializeUserPaths();
                    continue;
                }

                if (retryOrEnd.equals("Q")) {
                    break;
                }
            }

            currentLocation++;
        }

        System.out.println();

        outputView.printResult(bridgeGame.getPassedPath(), currentLocation, tryCount);

    }
}
