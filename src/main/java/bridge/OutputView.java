package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void print_Result() {
        System.out.println("최종 게임 결과");
    }

    private String makeMap(List<String> GameBoard, int now, String Checking) {
        String Closed_section = "[";
        for (int i = 0; i < GameBoard.size(); i ++){
            String tmp = "   ";
            if (GameBoard.get(i).contains(Checking)){
                tmp = " O ";
            }
            if (i == GameBoard.size() -1 && now == 0 && GameBoard.get(i).contains(Checking)) {
                tmp = " X ";
            }
            Closed_section = Closed_section.concat(tmp);
            if (i < GameBoard.size() -1){
                Closed_section = Closed_section.concat("|");
            }
        }
        return Closed_section.concat("]");
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, List<String> GameBoard, int now) {
        System.out.println(makeMap(GameBoard, now, "U"));
        System.out.println(makeMap(GameBoard, now, "D"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String Result, int cnt) {
        System.out.println("게임 성공 여부: " + Result);
        System.out.println("총 시도한 횟수: " + cnt);
    }
}
