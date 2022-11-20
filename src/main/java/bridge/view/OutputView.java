package bridge.view;

import bridge.game.bridgeGame.BridgeGame;
import bridge.game.bridgeGame.BridgeGameResults;
import bridge.game.bridgeGame.BridgeGameStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String COMMENT_START = "다리 건너기 게임을 시작합니다.";
    private final String COMMENT_INPUT_SIZE = "다리의 길이를 입력해주세요.";
    private final String COMMENT_INPUT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String COMMENT_CHOICE_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String COMMENT_SUCCESS = "게임 성공 여부: 성공";
    private final String COMMENT_FAIL = "게임 성공 여부: 실패";
    private final String COMMENT_TRY_COUNT = "총 시도한 횟수: ";


    public void printStart() {
        System.out.println(COMMENT_START);
    }

    public void printInputSize() {
        System.out.println(COMMENT_INPUT_SIZE);
    }

    public void printInputMove() {
        System.out.println(COMMENT_INPUT_MOVE);
    }

    public void printChoiceRestart() {
        System.out.println(COMMENT_CHOICE_RESTART);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGameResults bridgeResults) {
        System.out.println(bridgeResults.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getBridgeResults());
        System.out.println();
        checkStatus(bridgeGame.getBridgeGameStatus());

        System.out.println(COMMENT_TRY_COUNT + tryCount);
    }

    private void checkStatus(BridgeGameStatus bridgeGameStatus) {
        if (bridgeGameStatus.equals(BridgeGameStatus.CORRECT)) {
            System.out.println(COMMENT_SUCCESS);
            return;
        }
        System.out.println(COMMENT_FAIL);
    }
}

