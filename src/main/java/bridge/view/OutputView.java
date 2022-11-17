package bridge.view;

import bridge.domain.MoveStatus;
import bridge.domain.PlayResult;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.utils.Constants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(PlayResult playResult) {
        List<MoveStatus> result = playResult.getPlayResult();
        printUpBridge(result);
        printDownBridge(result);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private static void printUpBridge(List<MoveStatus> result) {
        System.out.println(makeUpBridge(result));
    }

    private static void printDownBridge(List<MoveStatus> result) {
        System.out.println(makeDownBridge(result));
    }

    private static String makeUpBridge(List<MoveStatus> result) {
        return OPEN_BRACKET + result.stream()
                .map(MoveStatus::isUp)
                .collect(Collectors.joining(SEPARATOR)) + CLOSE_BRACKET;
    }

    private static String makeDownBridge(List<MoveStatus> result) {
        return OPEN_BRACKET + result.stream()
                .map(MoveStatus::isDown)
                .collect(Collectors.joining(SEPARATOR)) + CLOSE_BRACKET;
    }
}
