package bridge;

public class GameController {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String UPDOWN_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    private BridgeGame bridgeGame = new BridgeGame();
    private InputView inputView = new InputView();

    public void GameController() {

    }

    public void GameStart() {
        System.out.println(START_MESSAGE + "\n" +LENGTH_MESSAGE+ "\n");
        inputView.readBridgeSize();
    }
}
