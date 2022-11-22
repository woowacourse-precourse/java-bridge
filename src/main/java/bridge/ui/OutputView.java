package bridge.ui;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printInsertBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printBridgeSize(int size) {
        System.out.println(size+"\n");
    }

    public void printInsertMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public String printMove(String move) {
        System.out.println(move);
        return move;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> Map) {
        int up = 0;
        int down = 1;

        System.out.println(MapTransform(Map.get(up)));
        System.out.println(MapTransform(Map.get(down)));
    }

    private String MapTransform(List<String> Map) {
        String delimiter = " | ";
        String prefix = "[ ";
        String suffix = " ]";

        StringJoiner joiner = new StringJoiner(delimiter, prefix, suffix);
        Map.forEach(item -> joiner.add(item));
        return joiner.toString();
    }

    public void printInsertRestart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public String printRestart(String restart) {
        System.out.println(restart + "\n");
        return restart;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> Map, Boolean Success, int tryNumber) {
        System.out.println("\n최종 게임 결과");
        printMap(Map);
        System.out.println("\n게임 성공 여부: " + SuccessTransform(Success));
        System.out.println("총 시도한 횟수: " + tryNumber);
    }

    private String SuccessTransform(Boolean Success) {
        if(Success) return "성공";
        return "실패";
    }
}
