package bridge.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private List<String> upSide = new ArrayList<>();
    private List<String> downSide = new ArrayList<>();

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int index) {
        printPreBracket();
        for (int i = 0; i < index; i++) {
            System.out.print(upSide.get(i));
        }
        printPostBracket();
        printPreBracket();
        for (int i = 0; i < index; i++) {
            System.out.print(downSide.get(i));
        }
        printPostBracket();
    }

    public void setUpandDownSide(String userMove, String answer) {
        if (userMove.equals("U")) {
            setUpSide(userMove, answer);
        }
        if (userMove.equals("D")) {
            setDownSide(userMove, answer);
        }
    }

    private void setUpSide(String userMove, String answer) {
        if (userMove.equals(answer)) {
            upSide.add(" O ");
            downSide.add("   ");
        }
        if (!userMove.equals(answer)) {
            upSide.add(" X ");
            downSide.add("   ");
        }
    }

    private void setDownSide(String userMove, String answer) {
        if (userMove.equals(answer)) {
            upSide.add("   ");
            downSide.add(" O ");
        }
        if (!userMove.equals(answer)) {
            upSide.add("   ");
            downSide.add(" X ");
        }
    }

    private void printPreBracket() {
        System.out.print("[");
    }

    private void printPostBracket() {
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
