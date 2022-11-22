package bridge;

public class Application {

    public static void main(String[] args) {

        InputView userInput = new InputView();
        OutputView guideDocument = new OutputView();

        guideDocument.printStartDocs();

        int bridgeSize = UserInputValidator.validateUsersBridgeSize(userInput,guideDocument);

        BridgeGame bridgeGame =
                new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));

        GameStatus status = GameStatus.GAME_ONGOING;
        int retryCount = 1;
        boolean isSucceed = false;
        while (status != GameStatus.GAME_CLEAR && status != GameStatus.GAME_GIVEUP) {

            status = bridgeGame.move(UserInputValidator.validateUsersBridgeMove(userInput,guideDocument));
            guideDocument.printMap(bridgeGame.getResult());

            if (status == GameStatus.GAME_OVER) {
                status = bridgeGame.retry(UserInputValidator.validateUsersReTry(userInput,guideDocument));
            }
        }
        if (status == GameStatus.GAME_CLEAR) {
            isSucceed = true;
        }
        guideDocument.printResult(bridgeGame.getResult(),isSucceed,bridgeGame.getTryCount());
        }
    }

    class UserInputValidator {
    public static int validateUsersBridgeSize(InputView userInput, OutputView outputView) {

        while (true) {
            try {
                outputView.printRequestBridgeLengthDocs();
                return userInput.readBridgeSize();

            }
            catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        }
    }

    public static String validateUsersBridgeMove(InputView userInput, OutputView outputView) {

        while (true) {
            try {
                outputView.printRequestSelectDocs();
                return userInput.readMoving();

            }
            catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static String validateUsersReTry(InputView userInput, OutputView outputView) {

        while (true) {
            try {
                outputView.printSelectRetryDocs();
                return userInput.readGameCommand();

            }
            catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }


    }
