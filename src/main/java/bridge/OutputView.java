package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> answer, int n, boolean last) {
        String[][] path = getMap(answer, n, last);
        StringBuilder up = new StringBuilder("[ ");
        StringBuilder down = new StringBuilder("[ ");
        for (int i = 0; i < n; i++) {
            up.append(path[0][i]).append(" | ");
            down.append(path[1][i]).append(" | ");
        }
        up.append(path[0][n]).append(" ]");
        down.append(path[1][n]).append(" ]");
        System.out.println(up + "\n" + down);
    }

    public String[][] getMap(List<String> answer, int n, boolean last) {
        String[][] path = new String[2][n + 1];
        for (int i = 0; i < n; i++) {
            if (answer.get(i).equals("U")) {
                path[0][i] = "O";
                path[1][i] = " ";
                continue;
            }
            path[0][i] = " ";
            path[1][i] = "O";
        }
        String lastPath = answer.get(n);
        if (last) {
            if (lastPath.equals("U")) {
                path[0][n] = "O";
                path[1][n] = " ";
            } else if (lastPath.equals("D")) {
                path[0][n] = " ";
                path[1][n] = "O";
            }
            return path;
        }
        if (lastPath.equals("U")) {
            path[0][n] = " ";
            path[1][n] = "X";
        } else if (lastPath.equals("D")) {
            path[0][n] = "X";
            path[1][n] = " ";
        }
        return path;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> answer, int n, boolean result) {
        System.out.println("최종 게임 결과");
        printMap(answer, n, result);
        System.out.print("게임 성공 여부: ");
        if (result){
            System.out.println("성공");
            return;
        }
        System.out.println("실패");

    }
}
