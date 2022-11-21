package bridge.UI;

import static bridge.Messages.*;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upSideDownSideMove) {
        for (String move : upSideDownSideMove) {
            move = move.replaceFirst("^", "[").replaceFirst(".$", "]");
            System.out.println(move.toString());
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> upSideDownSideMove, int retryCount) {
        System.out.println("\n" + OUTPUT_RESULT);
        for (String move : upSideDownSideMove) {
            move = move.replaceFirst("^", "[").replaceFirst(".$", "]");
            System.out.println(move.toString());
        }
        System.out.printf(OUTPUT_SUCCESS_FAILURE, getSuccessFailure(upSideDownSideMove));
        System.out.printf(OUTPUT_RETRY_COUNT, retryCount);
    }

    public String getSuccessFailure(List<String> upSideDownSideMove) {
        if (upSideDownSideMove.stream().anyMatch(move -> move.contains("X"))) {
            return FAILURE;
        }
        return SUCCESS;
    }
}
