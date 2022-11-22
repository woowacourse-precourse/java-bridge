package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printMap(List<String> bridge, int size, String userInput) {
        System.out.print("[");
        for(int i = 0; i < size-1;i++){
            printMapChar(bridge.get(i), "U");
        }
        printLastChar(bridge.get(size), "U", userInput);
        for(int i = 0; i < size-1;i++){
            printMapChar(bridge.get(i), "D");
        }
        printLastChar(bridge.get(size), "D", userInput);
    }

    private static int printMapChar(String bridgeChar, String upDown){
        if(bridgeChar.equals(upDown)){
            System.out.print(" O |");
            return 0;
        }
        System.out.print("   |");
        return 0;
    }

    private static int printLastChar(String bridgeChar, String upDown, String userInput){
        if(!bridgeChar.equals(upDown) && userInput.equals(upDown)){
            System.out.println(" X ]");
            return 0;
        }
        if(bridgeChar.equals(userInput) && bridgeChar.equals(upDown)){
            System.out.println(" O ]");
            return 0;
        }
        System.out.println(" X ]");
        return 0;
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

    }

    public static void errorHandling(String errorMessage){
        System.out.println("[ERROR]" + errorMessage);
        throw new IllegalArgumentException();
    }
}
