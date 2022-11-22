package bridge.presentation.view;

import bridge.domain.Move;
import bridge.domain.Moving;
import java.util.List;

public class OutputView {

    private final static String MAP_PREFIX = "[ ";
    private final static String MAP_SUFFIX = " ]";
    private final static String MAP_SEPARATOR = " | ";

    private final static String SENTENCE_OF_GAME_START = "다리 건너기 게임을 시작합니다.";

    public void printGameStart() {
        System.out.println(SENTENCE_OF_GAME_START);
    }

    public void printMap(Moving moving) {
        printMap(moving.getMovingResult(Move.UP));
        printMap(moving.getMovingResult(Move.DOWN));
    }

    private void printMap(List<String> movingResult) {
        System.out.println(MAP_PREFIX + String.join(MAP_SEPARATOR, movingResult) + MAP_SUFFIX);
    }

}
