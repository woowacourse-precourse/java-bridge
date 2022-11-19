package bridge.views;

import bridge.models.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * - 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
 * - `OutputView`의 패키지는 변경할 수 있다.
 * - `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * - 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    private static final String START = "[";
    private static final String END = "]";
    private static final String SEPARATOR = "|";
    private static final String CORRECT = " O ";
    private static final String INCORRECT = " X ";
    private static final String BLANK = "   ";
    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";

    private final StringBuilder mapUpstairs = new StringBuilder();
    private final StringBuilder mapDownstairs = new StringBuilder();
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String direction, boolean isCorrect, int bridgeIndex) {
        makeMap(direction, isCorrect, bridgeIndex);
        System.out.println(START + mapUpstairs + END);
        System.out.println(START + mapDownstairs + END);
    }

    private void makeMap(String direction, boolean isCorrect, int bridgeIndex) {
        addSeparator(mapUpstairs, bridgeIndex);
        addSeparator(mapDownstairs, bridgeIndex);
        if (direction.equals("U")) {
            addStatus(mapUpstairs, isCorrect);
            addBlank(mapDownstairs);
        // TODO else 예약어 없앨 방법은?
        } else if (direction.equals("D")) {
            addBlank(mapUpstairs);
            addStatus(mapDownstairs, isCorrect);
        }
    }

    private void addBlank(StringBuilder str) {
        str.append(BLANK);
    }

    private void addStatus(StringBuilder str, boolean isCorrect) {
        if (isCorrect) {
            str.append(CORRECT);
            return;
        }
        str.append(INCORRECT);
    }

    private void addSeparator(StringBuilder str, int bridgeIndex) {
        if (bridgeIndex != 0) {
            str.append(SEPARATOR);
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.printf("%n최종 게임 결과%n");
        System.out.println(START + mapUpstairs + END);
        System.out.println(START + mapDownstairs + END);
        System.out.printf("게임 성공 여부: %s%n", getResult(bridgeGame));
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTrialCount());
    }

    private String getResult(BridgeGame bridgeGame) {
        if (bridgeGame.gameSuccess()) {
            return GAME_SUCCESS;
        }
        return GAME_FAIL;
    }
}
