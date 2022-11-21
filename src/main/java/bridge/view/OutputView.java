package bridge.view;

import bridge.model.GameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void printResult(List<String> bridgeState, int tryTime, String userState) {
        System.out.println("\n최종 게임 결과");
        printMap(bridgeState);
        System.out.print("\n게임 성공 여부: ");
        System.out.println(userState);
        System.out.println("총 시도한 횟수: " + tryTime);
    }
}
