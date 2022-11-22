package bridge.view;

import bridge.domain.Message;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR_TAG = "[ERROR]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String upBridge, String downBridge) {
        System.out.println(upBridge + "\n" + downBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String successMessage, Integer tryCount) {
        System.out.println(Message.RESULT_IS_SUCCESS.getMessage() + successMessage);
        System.out.println(Message.RESULT_TRY.getMessage() + tryCount.toString());
    }

    public void printMapResult(String upBridge, String downBridge){
        System.out.println(Message.RESULT_MAP_MESSAGE.getMessage());
        System.out.println(upBridge + "\n" + downBridge);
    }

    public void printStartMessage(){
        System.out.println(Message.GAME_START.getMessage());
    }

    public void printMapInputMessage(){
        System.out.println(Message.INPUT_SIZE.getMessage());
    }

    public void printRetryMessage(){
        System.out.println(Message.RETRY.getMessage());
    }

    public void printMoveMessage(){
        System.out.println(Message.MOVE.getMessage());
    }

    public void printError(String message){
        System.out.println(ERROR_TAG + message);
    }
}
