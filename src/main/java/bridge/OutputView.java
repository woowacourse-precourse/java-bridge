package bridge;



import java.util.ArrayList;
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
    public static void printMap(List<String> bridgeInfo, int i, String movement) {
        if(i == 0){
            BridgeCheck.BridgeCheckIfIZero(bridgeInfo, movement);
        }

        if(i != 0){
            printUpBridge(bridgeInfo, i, movement);
            printDownBridge(bridgeInfo, i, movement);
        }
    }

    public static void printUpBridge(List<String> bridgeInfo, int i, String movement){
        System.out.print("[");
        for (int j = 0; j < i; j++){
            if (bridgeInfo.get(j).equals("U")){
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
        printUpBridgeLast(bridgeInfo, i, movement);
    }

    public static void printUpBridgeLast(List<String> bridgeInfo, int i, String movement){
        if (movement == "U"){
            if (bridgeInfo.get(i).equals(movement)){
                System.out.println(" O ]");
                return;
            }
            System.out.println(" X ]");
            return;
        }
        System.out.println("   ]");
    }

    public static void printDownBridge(List<String> bridgeInfo, int i, String movement){
        System.out.print("[");
        for (int j = 0; j < i; j++){
            if (bridgeInfo.get(j).equals("D")){
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
        printDownBridgeLast(bridgeInfo, i, movement);
    }

    public static void printDownBridgeLast(List<String> bridgeInfo, int i, String movement){
        if (movement == "D"){
            if (bridgeInfo.get(i).equals(movement)){
                System.out.println(" O ]");
                return;
            }
            System.out.println(" X ]");
            return;
        }
        System.out.println("   ]");
    }
    public static void printMapIfIZero(List<String> bridgeInfo){
        if (bridgeInfo.get(0).equals("U")){
            System.out.println("[ O ]\n[   ]");
        }

        if (bridgeInfo.get(0).equals("D")){
            System.out.println("[   ]\n[ O ]");
        }
    }

    public static void printMapIfIZeroNotEqual(String movement){
        if(movement == "U"){
            System.out.println("[ X ]\n[   ]");
        }
        if(movement == "D"){
            System.out.println("[   ]\n[ X ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String completeOrNot, List<String> bridgeInfo, int gameCount, int size) {
        System.out.println("최종 게임 결과");
        printResultMap(completeOrNot, bridgeInfo, size);
        System.out.println("총 시도한 횟수: " + gameCount);
        System.exit(0);
    }

    public static void printResultMap(String completeOrNot, List<String> bridgeInfo, int size){
        if(completeOrNot.contains("Q")){
            int tmp = Integer.parseInt(completeOrNot.replace("Q", ""));
            System.out.print("[");
            printResultUpBridgeMap(tmp, bridgeInfo);
            printResultDownBridgeMap(tmp, bridgeInfo);
            return;
        }
        printResultUpBridgeRightMap(size, bridgeInfo);
        printResultDownBridgeRightMap(size, bridgeInfo);
    }

    public static void printResultUpBridgeRightMap(int size, List<String> bridgeInfo){
        System.out.print("[");
        for (int i = 0; i < size; i++){
            if (bridgeInfo.get(i).equals("U")){
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
        printUpMapLast(size, bridgeInfo);
    }

    public static void printUpMapLast(int size, List<String> bridgeInfo){
        if (bridgeInfo.get(size).equals("U")){
            System.out.println(" O ]");
            return;
        }
        System.out.println("   ]");
    }

    public static void printResultDownBridgeRightMap(int size, List<String> bridgeInfo){
        System.out.print("[");
        for (int i = 0; i < size; i++){
            if (bridgeInfo.get(i).equals("D")){
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
        printDownMapLast(size, bridgeInfo);
    }

    public static void printDownMapLast(int size, List<String> bridgeInfo){
        if (bridgeInfo.get(size).equals("D")){
            System.out.println(" O ]");
            return;
        }
        System.out.println("   ]");
    }

    public static void printResultUpBridgeMap(int tmp, List<String> bridgeInfo){
        for (int i = 0; i < tmp; i++){
            if(bridgeInfo.get(i).equals("U")){
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
        printResultUpBridgeMapLast(tmp, bridgeInfo);
    }

    public static void printResultUpBridgeMapLast(int tmp, List<String> bridgeInfo){
        if(bridgeInfo.get(tmp).equals("U")){
            System.out.println("   ]");
            return;
        }
        System.out.println(" X ]");
    }

    public static void printResultDownBridgeMap(int tmp, List<String> bridgeInfo){
        for (int i = 0; i < tmp; i++){
            if(bridgeInfo.get(i).equals("D")){
                System.out.print(" O |");
                continue;
            }
            System.out.print("   |");
        }
        printResultDownBridgeMapLast(tmp, bridgeInfo);
    }

    public static void printResultDownBridgeMapLast(int tmp, List<String> bridgeInfo){
        if(bridgeInfo.get(tmp).equals("D")){
            System.out.println("   ]");
            return;
        }
        System.out.println(" X ]");
    }

    /**
     * 에러를 출력한다.
     */
    public static void printError(int whichError){
        if (whichError == 1) {
            ErrorReason(1);
            throw new IllegalArgumentException();
        }
        if (whichError == 2) {
            ErrorReason(2);
            throw new IllegalArgumentException();
        }
    }

    public static void ErrorReason(int whichError){
        if (whichError == 1){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        if (whichError == 2){
            System.out.println("[ERROR] 이동할 칸은 U 또는 D여야 합니다.");
        }
    }

    /**
     * 다리 건너기 게임 시작.
     */
    public static void printGameHasStarted(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public static void whatSizeBridge(){
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printInputWhereToGo(){
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printInputReGameOrNot(){
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
