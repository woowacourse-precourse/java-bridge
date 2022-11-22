package bridge.presentation.view;

import bridge.application.BridgeGame;
import bridge.domain.Count;
import bridge.domain.Move;
import bridge.domain.Moving;
import bridge.domain.Result;
import java.util.List;

public class OutputView {

    private final static String MAP_PREFIX = "[ ";
    private final static String MAP_SUFFIX = " ]";
    private final static String MAP_SEPARATOR = " | ";

    private final static String SUCCESS = "성공";
    private final static String FAIL = "실패";

    private final static String SENTENCE_OF_GAME_START = "다리 건너기 게임을 시작합니다.";
    private final static String SENTENCE_OF_GAME_RESULT = "최종 게임 결과";
    private final static String SENTENCE_OF_SUCCESS_OR_FAILURE = "게임 성공 여부: ";
    private final static String SENTENCE_OF_TOTAL_COUNT = "총 시도한 횟수: ";

    public void printGameStart() {
        System.out.println(SENTENCE_OF_GAME_START);
    }

    public void printMap(Moving moving) {
        printMap(moving.getMovingResult(Move.UP));
        printMap(moving.getMovingResult(Move.DOWN));
    }

    public void printResult(BridgeGame bridgeGame) {
        printResultMap(bridgeGame.getMoving());
        printSuccessOrFailure(bridgeGame.getResult());
        printCount(bridgeGame.getCount());
    }

    private void printMap(List<String> movingResult) {
        System.out.println(MAP_PREFIX + String.join(MAP_SEPARATOR, movingResult) + MAP_SUFFIX);
    }

    private void printResultMap(Moving moving) {
        System.out.println(SENTENCE_OF_GAME_RESULT);
        printMap(moving);
    }

    private void printSuccessOrFailure(Result gameResult) {
        System.out.print(SENTENCE_OF_SUCCESS_OR_FAILURE);
        System.out.println(gameResult.getResultOfKorean());
    }

    private void printCount(Count count) {
        System.out.println(SENTENCE_OF_TOTAL_COUNT + count.getCount());
    }

}
