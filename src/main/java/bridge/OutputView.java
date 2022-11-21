package bridge;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upSide, List<String> downSide) {
        String upSideBridge = upSide.stream().collect(Collectors.joining(" | ", "[ ", " ]"));
        String downBridge = downSide.stream().collect(Collectors.joining(" | ", "[ ", " ]"));
        System.out.println(upSideBridge);
        System.out.println(downBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String upSideBridge, String downSideBridge, int count) {
        System.out.println("최종 게임 결과");
        System.out.println(upSideBridge);
        System.out.println(downSideBridge);
        if (upSideBridge.contains("X") || downSideBridge.contains("X")){
            System.out.println("게임 성공 여부: 실패");
            System.out.println("총 시도한 횟수: " + count);
            return;
        }
        System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: " + count);
    }
}