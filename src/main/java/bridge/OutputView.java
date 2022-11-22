package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printMap(List<String> bridge, int size, String userInput) {
        System.out.print("[");
        for(int i = 0; i < size;i++){
            printMapChar(bridge.get(i), "U");
        }
        printLastChar(bridge.get(size), "U", userInput);
        System.out.print("[");
        for(int i = 0; i < size;i++){
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
        System.out.println("   ]");
        return 0;
    }

    public static void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getBridge(), bridgeGame.getNowIdx(), bridgeGame.getRecentInput());
        System.out.print("게임 성공 여부 : ");
        printWin(bridgeGame);
        System.out.print("총 시도한 횟수: ");
        System.out.println(bridgeGame.getTryTimes());
    }

    public static int printWin(BridgeGame bridgeGame){
        if(bridgeGame.getWin() == true){
            System.out.println("성공");
            return 0;
        }
        System.out.println("실패");
        return 0;
    }

    public static void errorHandling(String errorMessage){
        System.out.println("[ERROR]" + errorMessage);
        throw new IllegalArgumentException();
    }
}
