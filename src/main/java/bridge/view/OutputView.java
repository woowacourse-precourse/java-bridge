package bridge.view;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void printMap(List<String> bridge) {
        List<String> up = new ArrayList<String>();
        List<String> down = new ArrayList<String>();
        for (String move : bridge) {
            List<String> items = setItem(move);
            up.add(items.get(0));
            down.add(items.get(1));
        }
        printOneLine(up);
        printOneLine(down);
    }
    private List<String> setItem(String move) {
        Map map = new HashMap<String, String>();
        if (move.equals("U")) {
            return Arrays.asList("O", " ");
        } else if (move.equals("D")) {
            return Arrays.asList(" ", "O");
        } else if (move.equals("UX")) {
            return Arrays.asList("X", " ");
        }
        return Arrays.asList(" ", "X");
    }
    private void printOneLine(List<String> line) {
        System.out.print("[");
        for (int i = 0; i < line.size(); i++) {
            System.out.print(" " + line.get(i) + " ");
            if (i == line.size() - 1) {
                System.out.println("]");
            } else if (i != line.size() - 1) {
                System.out.print("|");
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
