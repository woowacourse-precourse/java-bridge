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
    private static final String CORRECT = "O";
    private static final String INCORRECT = "X";
    private static final String BLANK = " ";

    private String mapUpstairs = "";
    private String mapDownstairs = "";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String direction, boolean isCorrect) {
        String basicMap = " %s ";
        if (direction.equals("U")) {
            if (isCorrect) {
                if (mapUpstairs.isEmpty()) {
                    this.mapUpstairs += String.format(basicMap, CORRECT);
                    this.mapDownstairs += String.format(basicMap, BLANK);
                } else {
                    this.mapUpstairs += SEPARATOR + String.format(basicMap, CORRECT);
                    this.mapDownstairs += SEPARATOR + String.format(basicMap, BLANK);
                }
            } else {
                if (mapUpstairs.isEmpty()) {
                    this.mapUpstairs += String.format(basicMap, INCORRECT);
                    this.mapDownstairs += String.format(basicMap, BLANK);
                } else {
                    this.mapUpstairs += SEPARATOR + String.format(basicMap, INCORRECT);
                    this.mapDownstairs += SEPARATOR + String.format(basicMap, BLANK);
                }
            }
        } else {
            if (isCorrect) {
                if (mapUpstairs.isEmpty()) {
                    this.mapUpstairs += String.format(basicMap, BLANK);
                    this.mapDownstairs += String.format(basicMap, CORRECT);
                } else {
                    this.mapUpstairs += SEPARATOR + String.format(basicMap, BLANK);
                    this.mapDownstairs += SEPARATOR + String.format(basicMap, CORRECT);
                }
            } else {
                if (mapUpstairs.isEmpty()) {
                    this.mapUpstairs += String.format(basicMap, BLANK);
                    this.mapDownstairs += String.format(basicMap, INCORRECT);
                } else {
                    this.mapUpstairs += SEPARATOR + String.format(basicMap, BLANK);
                    this.mapDownstairs += SEPARATOR + String.format(basicMap, INCORRECT);
                }
            }
        }
        System.out.println(START + mapUpstairs + END);
        System.out.println(START + mapDownstairs + END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println();
        System.out.println("최종 게임 결과");
        System.out.println(START + mapUpstairs + END);
        System.out.println(START + mapDownstairs + END);
        System.out.println();
        if (bridgeGame.gameSuccess()) {
            System.out.println("게임 성공 여부: 성공");
        } else {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTrialCount());
    }
}
