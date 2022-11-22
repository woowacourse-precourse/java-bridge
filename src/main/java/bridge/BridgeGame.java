package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final static String O = " O ";
	private final static String X = " X ";
	private final static String EMPTY = "   ";
	private final BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker = new BridgeMaker(generator);
	private int bridgeLength;
	private int numberOfAttempt = 1;
	private boolean isSuccess = false;
	private Map<SideTypes, List<String>> result = new HashMap<>();
	private List<String> bridges;

	public int getBridgeLength() {
		return bridgeLength;
	}

	public BridgeGame(int bridgeLength) {
		this.bridgeLength = bridgeLength;
		this.bridges = this.bridgeMaker.makeBridge(bridgeLength);
		for (SideTypes types : SideTypes.values()) {
			result.put(types, new ArrayList<>());
		}
	}

	public int getCurrentIndex() {
		return result.get(SideTypes.U).size();
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean move(SideTypes type) {
		final int index = result.get(type).size();
		if (bridges.get(index).equals(type.getType())) {
			if (index + 1 == bridgeLength) {
				isSuccess = true;
			}
			return moveSuccess(type);
		}
		return moveFailure(type);
	}

	public int getNumberOfAttempt() {
		return numberOfAttempt;
	}

	public Map<SideTypes, List<String>> getResult() {
		return this.result;
	}

	public boolean isSuccess() {
		return this.isSuccess;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry(CommandTypes command) {
		if (command.equals(CommandTypes.R)) {
			this.bridges = this.bridgeMaker.makeBridge(this.bridgeLength);
			result.clear();
			for (SideTypes types : SideTypes.values()) {
				result.put(types, new ArrayList<>());
			}
			numberOfAttempt++;
			return true;
		}
		return false;
	}

	private boolean moveSuccess(SideTypes type) {
		if (type.equals(SideTypes.U)) {
			result.get(SideTypes.D).add(O);
			result.get(SideTypes.U).add(EMPTY);
			return true;
		}
		result.get(SideTypes.D).add(EMPTY);
		result.get(SideTypes.U).add(O);
		return true;
	}

	private boolean moveFailure(SideTypes type) {
		if (type.equals(SideTypes.U)) {
			result.get(SideTypes.D).add(X);
			result.get(SideTypes.U).add(EMPTY);
			return false;
		}
		result.get(SideTypes.D).add(EMPTY);
		result.get(SideTypes.U).add(X);
		return false;
	}

}
