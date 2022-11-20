package bridge.view;

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
    public void printMap(List<String> bridgeUpMap, List<String> bridgeDownMap, int location) {
        printMapElement(bridgeUpMap, location);
        System.out.println();
        printMapElement(bridgeDownMap, location);
        System.out.println();
        System.out.println();
    }

    private static void printMapElement(List<String> bridgeMap, int location) {
        printMapBoarderLeft();
        for (int i = 0; i <= location; i++) {
            System.out.print(bridgeMap.get(i));
            if (location != i) {
                printMapBar();
            }
        }
        printMapBoarderRight();
    }


    private static void printMapBar() {
        System.out.print(" | ");
    }

    private static void printMapBoarderLeft() {
        System.out.print("[ ");
    }

    private static void printMapBoarderRight() {
        System.out.print(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int retryCount, boolean success) {
        printSuccess(success);
        printFail(success);
        printRetryCount(retryCount);
    }

    public void printFinalMap(List<String> bridgeUpMap, List<String> bridgeDownMap, int location) {
        System.out.println("최종 게임 결과");
        printMap(bridgeUpMap, bridgeDownMap, location);
    }

    private static void printRetryCount(int retryCount) {
        System.out.println("총 시도한 횟수: " + retryCount);
    }

    private static void printSuccess(boolean success) {
        if (success == true) {
            System.out.println("게임 성공 여부: 성공");
        }
    }

    private static void printFail(boolean success) {
        if (success != true) {
            System.out.println("게임 성공 여부: 실패");
        }
    }

    public void printInit(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void printException(String message){
        System.out.println(message);
    }
}
