package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /** 프로그램 시작(게임 시작)을 출력하는 기능 */
    public void printGameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }
    /** 길이의 다리를 입력하라는 안내 문구를 출력하는 기능 */
    public void printGetBridgeSize(){
        System.out.println("다리의 길이를 입력해주세요.");
    }
    /** 이동할 칸을 선택하라는 안내 문구를 출력하는 기능 */
    public void printGetMoving(){
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    /** 사용자가 이동할 때마다 다리 건너기 결과를 출력하는 기능 */
    public void printMap(String upBridgeMap, String DownBridgeMap) {
        System.out.println("[" + upBridgeMap + "]");
        System.out.println("[" + DownBridgeMap + "]");
    }

    public void printResult() {
    }
}
