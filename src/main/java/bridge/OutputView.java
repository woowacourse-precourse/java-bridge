package bridge;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> userPlaying) {
        System.out.println(printLoop(userPlaying, "U"));
        System.out.println(printLoop(userPlaying, "D"));


    }

    public String printLoop(List<List<String>> userPlaying, String bridgeLocate) {
        String upPrint = "[";
        for (int i = 0; i< userPlaying.size(); i++) {
            if (i != 0)
                upPrint += "|";
            upPrint += printContent(userPlaying.get(i), bridgeLocate);
        }
        upPrint += "]";
        return upPrint;
    }

    public String printContent(List<String> currentPlaying, String bridgeLocate) {
        if (Objects.equals(currentPlaying.get(0), bridgeLocate))
            return " " + currentPlaying.get(1) + " ";
        return "   ";
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String isSuccess, int tryCount) {
        System.out.println("게임 성공 여부: " + isSuccess);
        System.out.println("총 시도한 횟수: " + tryCount);

    }
}
