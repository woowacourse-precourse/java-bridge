package bridge.ui;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String OPEN_SQUARE_BRACKET = "[ ";
    private static final String CLOSE_SQUARE_BRACKET = " ]";
    private static final String VERTICAL_BAR = " | ";
    private static final int FIRST_MOVE = 0;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> moveResult) {
        StringBuilder bridgeUpperResult = new StringBuilder();
        StringBuilder bridgeLowerResult = new StringBuilder();
        addFormat(bridgeUpperResult, bridgeLowerResult, OPEN_SQUARE_BRACKET);
        createMoveResultFormat(moveResult, bridgeUpperResult, bridgeLowerResult);
        addFormat(bridgeUpperResult, bridgeLowerResult, CLOSE_SQUARE_BRACKET);

        System.out.println(bridgeUpperResult + "\n" + bridgeLowerResult + "\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> moveResult, boolean isFailFinalGame, int retryCount) {
        System.out.println("최종 게임 결과");
        printMap(moveResult);
        printGameSuccessOrFail(isFailFinalGame);
        System.out.println("총 시도한 횟수: " + retryCount);
    }

    /**
     * 게임 시작을 정해진 형식에 맞춰 출력한다.
     */
    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 게임의 다리 길이 입력 받기 문구를 정해진 형식에 맞춰 출력한다.
     */
    public void printBridgeLengthInput() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 다리 칸 입력 받기 문구를 정해진 형식에 맞춰 출력한다.
     */
    public void printMovingSpaceChoice() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 게임 재시도 또는 종료 여부 문구를 정해진 형식에 맞춰 출력한다.
     */
    public void printRetryOrQuitChoice() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 이동한 다리의 상태를 정해진 출력 형식에 맞춰주는 로직
     */
    private void createMoveResultFormat(List<String> moveResult, StringBuilder bridgeUpperResult,
                                        StringBuilder bridgeLowerResult) {
        for (int i = 0; i < moveResult.size(); i += 2) {
            if (i == FIRST_MOVE) {
                bridgeUpperResult.append(moveResult.get(i));
                bridgeLowerResult.append(moveResult.get(i + 1));
                continue;
            }
            addFormat(bridgeUpperResult, bridgeLowerResult, VERTICAL_BAR);
            bridgeUpperResult.append(moveResult.get(i));
            bridgeLowerResult.append(moveResult.get(i + 1));
        }
    }

    /**
     * 처음과 끝을 정해진 출력 형식에 맞춰주는 로직
     */
    private void addFormat(StringBuilder bridgeUpperResult, StringBuilder bridgeLowerResult,
                           String format) {
        bridgeUpperResult.append(format);
        bridgeLowerResult.append(format);
    }

    /**
     * 최종 게임 성공 여부를 정해진 형식에 맞춰 출력한다.
     */
    private void printGameSuccessOrFail(boolean isFailFinalGame) {
        if (isFailFinalGame) {
            System.out.println("게임 성공 여부: 실패");
            return;
        }
        System.out.println("게임 성공 여부: 성공");
    }
}
