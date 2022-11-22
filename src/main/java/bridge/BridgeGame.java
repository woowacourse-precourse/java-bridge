package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
	private Bridge bridge = new Bridge();

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean move(String userMove, int i) {
		return bridge.contains(userMove, i);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry(String select) {
		return select.equals(Constant.SPELLING_R);
	}

	public void setBridge(int userInputSize) {
		bridge.setBridge(bridgeMaker.makeBridge(userInputSize));
	}

}
