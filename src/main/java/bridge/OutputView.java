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


}
