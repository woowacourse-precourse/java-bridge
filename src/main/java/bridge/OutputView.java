package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void bridgeGameStart(){
        System.out.println(Message.GAME_START_MESSAGE.getMessage());
    }
    public static void bridgeLengthMessage(){System.out.println(Message.BRIDGE_LENGTH_REQUEST.getMessage());}
    public static void moveStepMessage(){
        System.out.println(Message.MOVING_REQUEST.getMessage());
    }
    public static void  retryMessage() {System.out.println(Message.RETRY_REQUEST.getMessage());}
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String result) {
        System.out.println(result);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result) {
        BridgeGame brgame = new BridgeGame();
        brgame.ResultMessage();
        System.out.println(result);
    }
}
