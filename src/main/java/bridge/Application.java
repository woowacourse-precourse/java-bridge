package bridge;

public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame game;

        output.printGameStartMessage();

        while (true) {
            try {
                output.printReadBridgeSizeMessage();
                game = new BridgeGame(bridgeMaker, input.readBridgeSize());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean isFail;
        boolean isRetry;

        System.out.println(game.getBridge());
        while (true) {
            while (true) {
                try {
                    output.printReadMovingMessage();
                    isFail = game.move(BridgeBlock.getBridgeBlockType(input.readMoving()));
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            output.printMap(game.getBridge(), game.getCurrentUserPosition(), isFail);

            if (isFail) {
                while (true) {
                    try {
                        output.printReadGameCommandMessage();
                        isRetry = game.retry(RetrySelector.getRetrySelectorType(input.readGameCommand()));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (!isRetry) {
                    break;
                }
            }

            if (game.getGameWinStatus()) {
                break;
            }
        }

        output.printResult(game.getBridge(), game.getCurrentUserPosition(), isFail);
        output.printResultMessage(game.getGameWinStatus(), game.getTotalTryCount());
    }
}
