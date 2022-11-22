package bridge.util;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.CompareResult;
import bridge.domain.User;
import bridge.view.ViewMaker;

public final class BridgeGame {

    private static int attemptNumber;
    private static int bridgeLocation;

    private BridgeGame() {
    }

    private static void init() {
        attemptNumber = 1;
        bridgeLocation = 0;
    }

    public static void run() {
        init();

        ViewMaker viewMaker = new ViewMaker(new BridgeMaker(new BridgeRandomNumberGenerator()));
        Client.requestBridgeConstruction(viewMaker);

        while (true) {
            if (!play(Client.introduceGameUser(viewMaker))) {
                break;
            }
        }
    }

    private static boolean play(User user) {
        CompareResult compareResult = user.requestDirection(bridgeLocation++);

        if (compareResult.isCorrectDirection()) {
            return !isEndPointCheck(user, compareResult);
        } else if (retryCheck(user)) {
            return true;
        }

        user.getViewMaker().printAttemptCount(attemptNumber);
        return false;
    }

    private static boolean isEndPointCheck(User user, CompareResult compareResult) {
        if (compareResult.isBridgeEndPoint()) {
            user.getViewMaker().printGameExit();

            user.getViewMaker().printAttemptCount(attemptNumber);
            return true;
        }

        return false;
    }

    private static boolean retryCheck(User user) {
        if (isRetry(user)) {
            bridgeLocation = 0;
            ++attemptNumber;

            return true;
        }

        return false;
    }

    private static boolean isRetry(User user) {
        return user.requestGameCommand();
    }

}
