package bridge.view;

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
    public void printMap(List<List<String>> result) {
        String upMap;
        upMap = "[ ";
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).get(0).equals("U")) {
                upMap = upMap + result.get(i).get(1) + " ";
            }
            if (result.get(i).get(0).equals("D")) {
                upMap = upMap + "  ";
            }
            if (result.size() - i != 1) {
                upMap += "| ";
            }
        }
        upMap = upMap + "]";
        String downMap;
        downMap = "[ ";
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).get(0).equals("U")) {
                downMap = downMap + "  ";
            }
            if (result.get(i).get(0).equals("D")) {
                downMap = downMap + result.get(i).get(1) + " ";
            }
            if (result.size() - i != 1) {
                downMap += "| ";
            }
        }
        downMap = downMap + "]";
        System.out.println(upMap);
        System.out.println(downMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> result, int repeat) {
        System.out.println("최종 게임 결과");
        printMap(result);

        if (result.get(result.size() - 1).get(1).equals("O")) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (result.get(result.size() - 1).get(1).equals("X")) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + repeat);
    }
}
