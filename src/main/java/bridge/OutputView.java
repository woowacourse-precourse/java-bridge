package bridge;

import java.util.Iterator;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public String lineMapper(List<String> bridge, List<String> moves, String line) {
        String map = "";
        for (int i = 0; i < moves.size(); i++) {
            String answer = bridge.get(i);
            String move = moves.get(i);
            if (answer.equals(line) && move.equals(line)) {map = map + " O ,";}
            if (answer.equals(line) && !move.equals(line)) {map = map + "   ,";}
            if (!answer.equals(line) && move.equals(line)) {map = map + " X ,";}
            if (!answer.equals(line) && !move.equals(line)) {map = map + "   ,";}
            }
        return "[" + String.join("|", map.split(",")) + "]";
        }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> printMap(List<String> bridge, List<String> moves) {
        String upLine = lineMapper(bridge, moves, "U");
        String downLine = lineMapper(bridge, moves, "D");

        System.out.println(upLine);
        System.out.println(downLine);

        return List.of(upLine, downLine);


    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> moves) {
        System.out.println("최종 게임 결과");
        printMap(bridge, moves);

    }

    public void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void gameResult(boolean hit) {
        if (hit) {System.out.println("게임 성공 여부: 성공");}
        if (!hit) {System.out.println("게임 성공 여부: 실패");}
    }

    public void tryNumber(int tryCount) {
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void printGameEnding(List<String> bridge, List<String> moves, boolean hit, int count) {
        printResult(bridge, moves);
        gameResult(hit);
        tryNumber(count);
    }
}
