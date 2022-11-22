package bridge.Service;

import bridge.BridgeGame;
import bridge.Domain.Bridge;
import bridge.Domain.State;
import bridge.Domain.UserBridges;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameService {

    public void gameStart(Bridge bridge, UserBridges userBridges) {
        State currentState;
        int tries;

        for (tries = 1; ; tries++) {
            currentState = run(bridge, userBridges);

            if (currentState == State.END_OF_BRIDGE) break;
            if (retryOrNot(userBridges) == State.QUIT) break;
        }
        OutputView.printResult(userBridges, currentState, tries);
    }

    public State run(Bridge bridge, UserBridges userBridges) {

        for (int location = 0; location < bridge.getSize(); location++) {
            State result = moveMap(bridge, userBridges, location);
            OutputView.printMap(userBridges);

            if (result == State.WRONG_CHOICE)
                return result;
        }
        return State.END_OF_BRIDGE;
    }

    public State moveMap(Bridge bridge, UserBridges userBridges, int location) {
        OutputView.printEnterMovingSpace();

        String moving = InputView.readMoving();
        String space = bridge.getSpaceByLocation(location);

        return BridgeGame.move(moving, space, userBridges);
    }

    public State retryOrNot(UserBridges userBridges) {
        OutputView.printRetryOrQuit();

        String retry = InputView.readGameCommand();
        if (retry.equals("Q"))
            return State.QUIT;

        BridgeGame.retry(userBridges);
        return State.RETRY;
    }
}
