package bridge.UI.Output; //패키지 변경

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * 메서드의 이름은 변경할 수 없다
     */
    public void printMap(Map<Integer, Map<String, String>> userStatus) {
        UpperLowerMap upperLowerMap = new UpperLowerMap();

        StringBuilder up = upperLowerMap.printUpperMap(userStatus,"U");
        StringBuilder down = upperLowerMap.printUpperMap(userStatus,"D");

        MapFormatter mapFormatter = new MapFormatter();
        System.out.println(mapFormatter.changeMapFormat(up));
        System.out.println(mapFormatter.changeMapFormat(down));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * 메서드의 이름은 변경할 수 없다
     */
    public void printResult(Map<Integer, Map<String, String>> userStatus, CountRound countRound) {
        Collection<String> result = userStatus.get(userStatus.size()-1).values();
        System.out.println(OutputString.FINAL_RESULT.getMessage());
        if(result.stream().anyMatch(wrong -> wrong.equals("X"))){
            System.out.println(OutputString.SUCCESS_OR_FAIL.getMessage() + "실패");
        }
            System.out.println(OutputString.SUCCESS_OR_FAIL.getMessage() + "성공");
            System.out.println(OutputString.TOTAL_PLAYED_NUM.getMessage() + countRound.getRound());
    }

}
