package bridge;

import java.util.List;
import java.util.ArrayList;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> playerMove) {
        List<String> answer = getAnswer(bridge, playerMove);
        printBridge(answer, playerMove);
    }

    private List<String> getAnswer(List<String> bridge, List<String> playerMove){
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < playerMove.size(); i++){
            answer.add(compareStair(bridge.get(i), playerMove.get(i)));
        }

        return answer;
    }

    private List<String> makeStair(List<String> answer, List<String> playerMove, String direction){
        List<String> stair = new ArrayList<>();

        for(int i = 0 ; i < answer.size(); i++){
            if(playerMove.get(i).equals(direction)){
                stair.add(answer.get(i));
                continue;
            }
            stair.add(" ");
        }
        return stair;
    }
    private void printBridge(List<String> answer, List<String> playerMove){
        List<String> upStair = makeStair(answer, playerMove, "U");
        List<String> downStair = makeStair(answer, playerMove, "D");

        String upStr = String.join("|", upStair);
        String downStr = String.join("|", upStair);

        System.out.println(upStr);
        System.out.println(downStr);
    }

    private String compareStair(String bridge, String move){
        if(bridge.equals(move))
            return "O";

        return "X";
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
