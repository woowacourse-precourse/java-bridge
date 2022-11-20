package bridge;

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
    public void printMap(List<String> userBridge, List<String> answerBridge) {
        String topLine="";
        String downLine="";
        topLine+=printTopLine(userBridge, answerBridge);
        downLine+=printDownLine(userBridge, answerBridge);
        System.out.println(topLine);
        System.out.println(downLine);
    }

    public String printTopLine(List<String> userBridge, List<String> answerBridge){
        String topLine="[ ";
        for(int index=0;index<userBridge.size();index++){
            if(!userBridge.get(index).equals("U")){
                topLine+="  ";
            }
            if(userBridge.get(index).equals("U")&&BridgeGame.checkSameMove(userBridge, answerBridge, index)){
                topLine+="O ";
            }
            if(userBridge.get(index).equals("U")&&!BridgeGame.checkSameMove(index)){
                topLine+="X ";
            }
            topLine+="| ";
        }
        topLine+="]";
        return topLine;
    }
    
    public boolean checkSameMove(List<String> userBridge, List<String> answerBridge, int index){
        if(userBridge.get(index)==answerBridge.get(index)){
            return true;
        }
        return false;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
