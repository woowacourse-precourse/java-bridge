package bridge;

import bridge.constants.Message;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /** 프로그램 시작(게임 시작)을 출력하는 기능 */
    public void printGameStart(){
        System.out.println(Message.GAME_START_MESSAGE + "\n");
    }
    /** 길이의 다리를 입력하라는 안내 문구를 출력하는 기능 */
    public void printGetBridgeSize(){
        System.out.println(Message.BRIDGE_SIZE_INPUT_MESSAGE);
    }
    /** 이동할 칸을 선택하라는 안내 문구를 출력하는 기능 */
    public void printGetMoving(){
        System.out.println("\n" + Message.BRIDGE_MOVING_INPUT_MESSAGE);
    }
    /** 이동할 칸을 선택하라는 안내 문구를 출력하는 기능 */
    public void printGetGameCommand(){
        System.out.println("\n" + Message.ASK_TO_RESTART_MESSAGE);
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
        System.out.println(Message.FINAL_GAME_TRY_COUNT_MESSAGE + gameTryCount);
    }
    /** 사용자의 게임 성공 or 실패 여부에 따라 줄바꿈 여부를 달리 출력하는 기능 */
    private boolean changLineOnSuccessOrFailure(boolean result){
        if (result){System.out.println("\n" + Message.FINAL_GAME_RESULT_GUIDE_MESSAGE);return true;}
        System.out.println(Message.FINAL_GAME_RESULT_GUIDE_MESSAGE);return true;
    }
    /** 사용자의 게임 성공 or 실패 여부에 따라 다른 메시지를 출력하는 기능 */
    private boolean printSuccessOrFailure(boolean result){
        if (result){System.out.println(Message.FINAL_GAME_SUCCESS_OR_NOT_MESSAGE + Message.SUCCESS);return true;}
        System.out.println(Message.FINAL_GAME_SUCCESS_OR_NOT_MESSAGE + Message.FAIL);return true;
    }
    /** 예외처리 출력 기능 */
    public static void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

}
