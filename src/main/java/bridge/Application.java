package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);


        int currentLocation = 0;
        while (currentLocation < bridgeSize) {
            String chosenPath = inputView.readMoving();
            boolean successOrFailure = bridgeGame.move(currentLocation, chosenPath);
            outputView.printMap(bridgeGame.getPassedPath(), successOrFailure);
            if (successOrFailure == false) {
                break;
            }

            currentLocation++;
        }

        System.out.println();

        outputView.printResult(bridgeGame.getPassedPath(), bridgeSize);


    }
}
