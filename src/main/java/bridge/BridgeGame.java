package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    public static int CURRENT_LOCATION = 1;
    public static int BRIDGE_SIZE;
    public static int retryCount = 1;

    public void move() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String moving = inputView.moveUser();
        List<String> moveCourse = new ArrayList<>();
        BRIDGE_SIZE = inputView.bridgeSize();

        if (moveCourse.size() == 0) {
            moveCourse.add(moving);
        }

        if(moveCourse.size() != 0 && moveCourse.get(moveCourse.size() - 1).equals(moving)) {
            retry();
        } else if (moveCourse.size() != 0 && !(moveCourse.get(moveCourse.size() - 1).equals(moving))) {
            CURRENT_LOCATION++;
            moveCourse.add(moving);
            outputView.printMap(moveCourse);
            if (BRIDGE_SIZE == CURRENT_LOCATION) {
                outputView.printResult(CURRENT_LOCATION, retryCount);
            }
        }

    }

    public void retry() {
        InputView inputView = new InputView();
        String gameCommand = inputView.readGameCommand();

        if(gameCommand.equals("R")) {
            inputView.readMoving();
            retryCount++;
        } else if (gameCommand.equals("Q")) {
            OutputView outputView = new OutputView();
            outputView.printResult(CURRENT_LOCATION, retryCount);
        }

    }
}