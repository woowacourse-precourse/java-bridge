package bridge;

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
        printLastChar(bridge.get(size-1), "U", userInput);
        System.out.print("[");
        for(int i = 0; i < size-1;i++){
            printMapChar(bridge.get(i), "D");
        }
        printLastChar(bridge.get(size-1), "D", userInput);
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
        System.out.println("   ]");
        return 0;
    }

    public void printResult() {
        System.out.println("최종 게임 결과");
        //다리 출력
        System.out.println("게임 성공 여부 : ");

    }

    public static void errorHandling(String errorMessage){
        System.out.println("[ERROR]" + errorMessage);
        throw new IllegalArgumentException();
    }
}
