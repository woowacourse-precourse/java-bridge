package bridge.view;

import bridge.BridgeGame;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_LENGTH_REQUEST_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String BRIDGE_MOVE_DIRECTION_REQUEST_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RESTART_OR_QUIT_REQUEST_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final String GAME_IS_SUCCESS_MESSAGE = "게임 성공 여부:";
    private final String GAME_ATTEMPTS = "총 시도한 횟수:";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printRequestBridgeLength() {
        System.out.println(BRIDGE_LENGTH_REQUEST_MESSAGE);
    }

    public void printRequestMoveDirection() {
        System.out.println(BRIDGE_MOVE_DIRECTION_REQUEST_MESSAGE);
    }

    public void printRequestRestartOrQuit() {
        System.out.println(RESTART_OR_QUIT_REQUEST_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> result) {
        for (int i = 0; i < 2; i++) {
            List<String> line = result.get(i);
            System.out.println("[ " + String.join(" | ", line) + " ]");
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {

        System.out.println(GAME_RESULT_MESSAGE);
        printMap(game.analyzeResult());
        System.out.println(GAME_IS_SUCCESS_MESSAGE + " " + successConverter(game.isSuccess()));
        System.out.println(GAME_ATTEMPTS + " " + game.getAttempt());
    }

    private String successConverter(Boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
        return "실패";
    }
}