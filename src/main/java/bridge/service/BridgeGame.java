package bridge.service;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeSize;
import bridge.model.ExitOption;
import bridge.model.FootPrint;
import bridge.model.GameResult;
import bridge.model.Map;
import bridge.model.Stairs;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	public List<String> setUpGame(int userInput) {
		BridgeSize bridgeSize = new BridgeSize(userInput);
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		return bridgeMaker.makeBridge(bridgeSize.getSize());
	}

	public void setUpRound(GameResult gameResult, Map map) {
		gameResult.changeResultToSuccess();
		gameResult.addNumberOfAttempts();
		map.resetMap();
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public List<String> move(Stairs stairs, String square) {
		int stairsNumber = stairs.getNumber();
		boolean isEqual = stairs.isEquals(square);
		return FootPrint.makeFootPrints(stairsNumber, isEqual);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry(ExitOption exitOption) {
		return exitOption.isReplay();
	}

}
