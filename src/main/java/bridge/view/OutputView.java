package bridge.view;

import bridge.Constants;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> moves, boolean isFail) {
        List<String> upperMap = partialMap(moves, isFail, Constants.CODE_UP);
        List<String> lowerMap = partialMap(moves, isFail, Constants.CODE_DOWN);

        System.out.println(Map.START.code() + String.join(Map.JOIN.code(), upperMap) + Map.END.code());
        System.out.println(Map.START.code() + String.join(Map.JOIN.code(), lowerMap) + Map.END.code());
    }

    private List<String> partialMap(List<String> moves, boolean isFail, String code) {
        return IntStream.range(0, moves.size()).mapToObj(index -> {
            if (isFail && index == moves.size() - 1 && moves.get(index).equals(code)) {
                return Map.MOVE_FAIL.code();
            }
            if (moves.get(index).equals(code)) {
                return Map.MOVE_SUCCESS.code();
            }
            return Map.MOVE_EMPTY.code();
        }).collect(Collectors.toList());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> moves, boolean isFail, int attempts) {
        printMap(moves, isFail);
        System.out.println(OutputMessage.GAME_RESULT.message());
        String result = OutputMessage.SUCCESS.message();
        if (isFail) {
            result = OutputMessage.FAIL.message();
        }
        System.out.printf(OutputMessage.SUCCESS_OR_FAIL.message(), result);
        System.out.printf(OutputMessage.ATTEMPT.message(), attempts);
    }
}
