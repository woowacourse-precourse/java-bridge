package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String[] map = new String[2];

    public OutputView() {
        map[0] = "[";
        map[1] = "[";
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        for (int i = 0; i < 2; i++) {
            System.out.println(map[i] + "]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int total_round, String success) {
        System.out.println("최종 게임 결과");
        printMap();
        System.out.println("게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + total_round);

    }

    /**
     * 사용자가 입력한 값에 따라 현재 상태를 갱신하다.
     *
     * @param result {" ","O","X"} : 현재 상태값
     */
    public void updateMap(String[] result) {
        if (map[0].contains("]")) {
            if (!map[1].equals("[")) map[1] += "|";
            map[1] = " " + result[1] + " ";
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (!map[i].equals("[")) map[i] += "|";
            map[i] += " " + result[i] + " ";
        }
    }

    /**
     * 다시 시작하기 위해 저장된 게임 진행 상황을 지운다.
     */
    public void reMap() {
        map[1] = "[";
    }
}
