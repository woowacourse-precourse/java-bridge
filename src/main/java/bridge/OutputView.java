package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param resultMap 형식에 맞춰 출력할 upperLines, bottomLines 를 가지고 있는 map
     */
    public void printMap(Map<String,List<String>> resultMap) {
        List<String> upperLine = resultMap.get("upperLine");
        List<String> bottomLine = resultMap.get("bottomLine");
        printLine(upperLine);
        printLine(bottomLine);
        System.out.println();
    }

    private void printLine(List<String> line){
        String result = "[ ";
        result += String.join(" | ",line);
        result += " ]";
        System.out.println(result);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param resultMap 형식에 맞춰 출력할 upperLines, bottomLines 를 가지고 있는 map
     * @param success 게임 성공 여부
     * @param attempts 시도 횟수
     */
    public void printResult(Map<String,List<String>> resultMap, boolean success, int attempts) {
        System.out.println("최종 게임 결과");
        printMap(resultMap);
        System.out.println("게임 성공 여부: " + getSuccessMessage(success));
        System.out.println("총 시도한 횟수: " + attempts);
    }

    private String getSuccessMessage(boolean success){
        String successMessage = "실패";
        if (success){
            successMessage = "성공";
        }
        return successMessage;
    }
}
