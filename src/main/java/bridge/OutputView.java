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
    /** 이동할 칸을 선택하라는 안내 문구를 출력하는 기능 */
    public void printGetGameCommand(){
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    /** 사용자가 이동할 때마다 다리 건너기 결과를 출력하는 기능 */
    public void printMap(String upBridgeMap, String DownBridgeMap) {
        System.out.println("[" + upBridgeMap + "]");
        System.out.println("[" + DownBridgeMap + "]");
    }
    /** 최종 게임 결과를 출력하는 기능 */
    public void printResult(boolean result, String upBridgeMap, String DownBridgeMap, int gameTryCount) {
        changLineOnSuccessOrFailure(result);
        System.out.println("[" + upBridgeMap + "]");
        System.out.println("[" + DownBridgeMap + "]\n");
        printSuccessOrFailure(result);
        System.out.println("총 시도한 횟수: " + gameTryCount);
    }
    /** 사용자의 게임 성공 or 실패 여부에 따라 줄바꿈 여부를 달리 출력하는 기능 */
    private boolean changLineOnSuccessOrFailure(boolean result){
        if (result){System.out.println("\n최종 게임 결과");return true;}
        System.out.println("최종 게임 결과");return true;
    }
    /** 사용자의 게임 성공 or 실패 여부에 따라 다른 메시지를 출력하는 기능 */
    private boolean printSuccessOrFailure(boolean result){
        if (result){System.out.println("게임 성공 여부: 성공");return true;}
        System.out.println("게임 성공 여부: 실패");return true;
    }

}
