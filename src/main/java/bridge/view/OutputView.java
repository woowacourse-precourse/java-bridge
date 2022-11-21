package bridge.view;

import bridge.domain.GameResult;
import bridge.domain.Map;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAIL_MESSAGE = "게임 성공 여부: ";
    private static final String ATTEMPT_MESSAGE = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map) {
        for (String bridge : map) {
            System.out.println(bridge);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Map map, GameResult result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(map.getUpMap());
        System.out.println(map.getDownMap());
        System.out.println();
        System.out.println(SUCCESS_OR_FAIL_MESSAGE + result.getSuccess());
        System.out.println(ATTEMPT_MESSAGE + result.getAttemptNumber());
    }

    public void printError(String message) {
        System.out.println(message);
        System.out.println();
    }
}
