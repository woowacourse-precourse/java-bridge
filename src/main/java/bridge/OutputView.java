package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(HashMap<String, List<String>> path) {
        String upPath = String.join(" | ", path.get("U")).replaceAll("N"," ");
        String downPath = String.join(" | ", path.get("D")).replaceAll("N"," ");
        System.out.println("[ "+ upPath+" ]");
        System.out.println("[ "+ downPath+" ]");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(HashMap<String, List<String>> path, String isSuccess, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(path);
        System.out.printf("\n게임 성공 여부: %s\n총 시도한 횟수: %d", isSuccess, tryCount);
    }
}
