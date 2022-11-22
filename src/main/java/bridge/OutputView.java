package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView{

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printUpDownBridge(List<String> bridge,List<String> userInput){
        printMap(bridge,userInput,BridgeStatus.UP.getValueString());
        printMap(bridge,userInput,BridgeStatus.DOWN.getValueString());
    }
    public static void printMap(List<String> bridge,List<String> userInput,String location) {
        System.out.print("[");
        for(int index=0;index<userInput.size();index++) {
            String indexUserInput = userInput.get(index);
            String indexBridge = bridge.get(index);
            printBridge(indexUserInput,indexBridge,location);
            if(index< userInput.size()-1){
                System.out.print("|");
            }
        }
        System.out.println("]");
    }
    public static void printBridge(String indexUserInput,String indexBridge,String location){
        if(indexUserInput.equals(location)&& indexUserInput.equals(indexBridge)){
            System.out.print(" O ");
        }
        if(!indexUserInput.equals(location)){
            System.out.print("   ");
        }
        if(indexUserInput.equals(location)&&!indexUserInput.equals(indexBridge)){
            System.out.print(" X ");
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> bridge,List<String> userInput,int gameCount) {
        System.out.println("최종 게임 결과");
        printUpDownBridge(bridge,userInput);
        if(BridgeGame.gameOver()){
            System.out.println("게임 성공 여부: 성공");
        }
        if(!BridgeGame.gameOver()){
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: "+gameCount);
    }

    public static void printGameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public static void printBridgeSize(){
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public static void printMove(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public static void printRetry(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
