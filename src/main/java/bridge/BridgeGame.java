package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final List<String> bridge;
	private int bridgeIndex;
	private MoveResult moveResult;
	private int retryNumber;

	public BridgeGame(int size) {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		this.bridge = bridgeMaker.makeBridge(size);
		this.bridgeIndex = 0;
		this.retryNumber = 1;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public String move(MoveCode moveCode) {
		moveResult = MoveResult.getMoveResultByInputCode(moveCode.getInputCode(), bridge.get(bridgeIndex));
		bridgeIndex++;
		return moveResult.getMoveResultCode();
	}

	public boolean canGoOn() {
		return bridgeIndex != bridge.size() && moveResult != MoveResult.CAN_NOT_MOVE;
	}

	public GameResult calculateGameResult() {
		if(bridgeIndex == bridge.size() && moveResult == MoveResult.CAN_MOVE) {
			return new GameResult(GameResultCode.SUCCESS, retryNumber);
		}
		return new GameResult(GameResultCode.FAIL, retryNumber);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		bridgeIndex = 0;
		retryNumber++;
		moveResult = MoveResult.CAN_MOVE;
	}
}
