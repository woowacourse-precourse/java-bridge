package game;

import exception.UserInputException;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public int play(List<String> bridge, int stage) {
        try {
            OutputView.printMoveChoiceMessage();
            //move(InputView.readMoving(), bridge.get(stage));
            System.out.println(stage);
            System.out.println(move(InputView.readMoving(), bridge.get(stage)));
            return stage;
        } catch (UserInputException e) {
            e.printStackTrace();
            return stage-1;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String movingFloor, String bridgeStatus) {
        if (movingFloor.equals(bridgeStatus)) {
            return GameResult.CORRECT_FLOOR.getResultMessage();
        }
        return GameResult.WRONG_FLOOR.getResultMessage();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
