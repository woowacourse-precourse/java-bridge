package bridge.domain.ui;

import bridge.domain.user.User;

import java.util.List;

import static bridge.domain.utils.Space.*;
import static bridge.domain.ui.ReservedMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    // 시작 메시지, 다리 길이를 입력받기 위한 메시지 출력
    public void printInitialMessages() {
        System.out.println(STARTING_MESSAGE.getMsg());
        System.out.println(MESSAGE_TO_GET_SIZE.getMsg());
    }

    // 이동할 칸을 입력받기 위한 메시지 출력
    public void printMessageToGetSpaceToMove() {
        System.out.println(MESSAGE_TO_GET_SPACE.getMsg());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(User user) {
        List<String> up = user.getCurrentBridge().get(UP.getIndex());
        List<String> down = user.getCurrentBridge().get(DOWN.getIndex());

        up.forEach(System.out::print);
        System.out.println();
        down.forEach(System.out::print);
        System.out.print("\n\n");
    }

    // 재시도 여부를 입력받기 위한 메시지 출력
    public void printMessageAfterFailure() {
        System.out.println(MESSAGE_TO_GET_WHETHER_RETRY_OR_NOT.getMsg());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(User user) {
        System.out.println(MESSAGE_TO_PRINT_RESULT.getMsg());
        printMap(user);
        printSucceedOrFailed(user);
        System.out.print(THE_NUMBER_OF_TRIAL.getMsg() + user.getTheNumOfTrials());
    }

    private static void printSucceedOrFailed(User user) {
        System.out.print(WHETHER_SUCCEED_OR_NOT.getMsg());
        if (user.getSucceeded()) {
            System.out.println(SUCCEEDED_MESSAGE.getMsg());
            return;
        }
        System.out.println(FAILED_MESSAGE.getMsg());
    }

}
