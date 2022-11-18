package bridge;

public class PrintCommand {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String GET_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    public void gameStart(){
        System.out.println(GAME_START_MESSAGE);
    }
    public void getBridgeLength(){
        System.out.println(GET_BRIDGE_LENGTH_MESSAGE);
    }
}
