package bridge;

import java.util.ArrayList;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    StringBuilder top;
    StringBuilder down;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map<Integer, ArrayList<String>> playerBridge) {
        printPlayerBridgeTop(playerBridge);
        printPlayerBridgeDown(playerBridge);
        System.out.println("\n");
    }

    public void printPlayerBridgeTop(Map<Integer, ArrayList<String>> playerBridge) {
        top = new StringBuilder();
        top.append("[");
        for(int i=0;i<playerBridge.size();i++){
            String position = playerBridge.get(i).get(0);
            String correct = playerBridge.get(i).get(1);
            if(position.equals("U")){
                top.append(correct);
            }
            if(position.equals("D")){
                top.append(" ");
            }
            if(i!=(playerBridge.size()-1)){
                top.append("|");
            }
        }
        top.append("]");
        System.out.println(top);
    }

    public void printPlayerBridgeDown(Map<Integer, ArrayList<String>> playerBridge) {
        down = new StringBuilder();
        down.append("[");
        for(int i=0;i<playerBridge.size();i++){
            String position = playerBridge.get(i).get(0);
            String correct = playerBridge.get(i).get(1);
            if(position.equals("U")){
                down.append(" ");
            }
            if(position.equals("D")){
                down.append(correct);
            }
            if(i!=(playerBridge.size()-1)){
                down.append("|");
            }
        }
        down.append("]");
        System.out.println(down);
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Map<Integer, ArrayList<String>> playerBridge, boolean isSuccess) {
        System.out.println("최종 게임 결과");
        printMap(playerBridge);
        if(isSuccess){
            System.out.println("게임 성공 여부: 성공");
        }
        if(!isSuccess){
            System.out.println("게임 성공 여부: 실패");
        }
    }

    public void printTotalAttempts(int attempts){
        System.out.println("총 시도한 횟수: " + attempts);
    }

}
