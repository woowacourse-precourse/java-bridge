package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private static final String GAME_START_INFO = "다리 건너기 게임을 시작합니다.";
	private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

	private void BridgeGame(){
	}

	public void play() {
		OutputView.printGameInfo(GAME_START_INFO);
		OutputView.printRequest(REQUEST_BRIDGE_SIZE);

		InputView inputView = new InputView();
		BridgeSize bridgeSize = inputView.readBridgeSize();
	}




	/**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
//    public void move() {
//		Movement movement =
//    }





    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
