package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static int CURRENT_LOCATION = 1;
    public static int BRIDGE_SIZE;
    public static int retryCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
