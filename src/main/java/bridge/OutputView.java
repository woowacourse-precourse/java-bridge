package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static String resultMap;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private static String checkForUpMap(String move, String log){
        if (move.equals("success") && log.equals("U")) {
            return " O ";
        }
        if (move.equals("success") && log.equals("D")) {
            return "   ";
        }
        if (move.equals("fail") && log.equals("U")) {
            return "   ";
        }
        if (move.equals("fail") && log.equals("D")) {
            return " X ";
        }
        return "   ";
    }

    private static String checkForDownMap(String move, String log){
        if(move.equals("success") && log.equals("U")){
            return "   ";
        }
        if(move.equals("success") && log.equals("D")){
            return " O ";
        }
        if(move.equals("fail")&& log.equals("U")){
            return " X ";
        }
        if(move.equals("fail")&& log.equals("D")){
            return "   ";
        }
        return "   ";
    }
    public void printMap(ArrayList<String> moveResult, List<String> bridge) {
        ArrayList<String> upMap = new ArrayList<>();
        ArrayList<String> downMap = new ArrayList<>();

        for (int i = 0; i < moveResult.size(); i++) {
            String move = moveResult.get(i);
            String log = bridge.get(i);
            upMap.add(checkForUpMap(move, log));
            downMap.add(checkForDownMap(move, log));
        }
        resultMap = upMap.toString().replaceAll(", ", "|") + "\n" + downMap.toString().replaceAll(", ", "|");
        System.out.println(resultMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int attempts) {
        System.out.println("최종 게임 결과");
        System.out.println(resultMap);
        System.out.println("게임 성공 여부: "+result);
        System.out.println("총 시도한 횟수: "+ attempts);
    }
}
