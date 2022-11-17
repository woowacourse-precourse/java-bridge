package bridge.view;

public class Print {
    private static String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static String REQUEST_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";

    public static void gameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }
    public static void requestBridgeLengthMessage(){
        System.out.println(REQUEST_BRIDGE_LENGTH_MESSAGE);
    }
    public static void exceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}

