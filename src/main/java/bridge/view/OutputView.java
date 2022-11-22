package bridge.view;

import static java.text.MessageFormat.format;
import static java.util.stream.Collectors.*;

import bridge.domain.MoveResult;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String MAP_MESSAGE_FORMAT = "[ {0} ]";
    private static final String MAP_MESSAGE_DELIMITER = " | ";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<MoveResult>> results) {
        for (List<MoveResult> result : results) {
            System.out.println(getMapMessage(result));
        }
    }

    private String getMapMessage(List<MoveResult> result) {
        return format(MAP_MESSAGE_FORMAT, result.stream()
                .map((MoveResult::toString))
                .collect(joining(MAP_MESSAGE_DELIMITER)));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
