package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStartMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.");
    }
    public void printSelectMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printRestartMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printBridgeSizeIntegerError(){ System.out.println("[ERROR] 잘못된 type이 입력되었습니다. (다리 길이: 3~20)\n"); }

    public void printBridgeSizeIntegerRangeError(){ System.out.println("[ERROR] 잘못된 다리 길이입니다. (다리 길이: 3~20)\n"); }

    public void printMovingError(){ System.out.println("[ERROR] 잘못된 입력입니다. (위: U, 아래: D)"); }

    public void printGameCommandError(){ System.out.println("[ERROR] 잘못된 입력입니다. (재시작: R, 종료: Q)"); }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<String> userMove, List<String> bridge) {
        List<String> upside = makemap("U",userMove,bridge);
        List<String> downside = makemap("D",userMove,bridge)  ;

        System.out.println("["+String.join("|",upside)+"]");
        System.out.println("["+String.join("|",downside)+"]\n");

        return upside.toString() + downside.toString();
    }

    public List<String> makemap(String position, List<String> userMove, List<String> bridge){
        List<String> myMap = new ArrayList<>();
        for(int i = 0; i<userMove.size(); i++){
            myMap.add(walk(position, userMove.get(i), bridge.get(i)));
        }
        return myMap;
    }

    public String walk(String position, String move, String oneBridge){
        if(!position.equals(move)){
            return "   ";
        }
        if(move.equals(oneBridge)){
            return " O ";
        }
        return " X ";
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userMove,List<String> bridge,int count) {
        System.out.println("최종 게임 결과");
        String printedMessage = printMap(userMove,bridge);
        if(printedMessage.contains("X")){
            System.out.println("게임 성공 여부: 실패"+"\n총 시도한 횟수: "+count);
            return;
        }
        System.out.println("게임 성공 여부: 성공"+"\n총 시도한 횟수: "+count);
    }
}
