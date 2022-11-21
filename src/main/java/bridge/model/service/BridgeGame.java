package bridge.model.service;

import java.util.List;

import bridge.model.domain.Bridges;
import bridge.model.domain.FootPrint;
import bridge.model.domain.GameResult;
import bridge.model.domain.Map;
import bridge.model.validation.ExitOption;
import bridge.model.validation.Stairs;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private final Bridges bridges;
	private final Map map;
	private final GameResult result;

	public BridgeGame() {
		this.bridges = new Bridges();
		this.map = new Map();
		this.result = new GameResult();
	}

	public void makeBridge(int userInput) {
		bridges.makeBridge(userInput);
	}

	public void setUpRound() {
		result.changeResultToSuccess();
		result.addNumberOfAttempts();
		map.resetMap();
	}

	public List<String> getBridges() {
		return bridges.getBridges();
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(String square, Stairs stairs) {
		result.chooseStairs(stairs.isEquals(square));
		List<String> footPrints = FootPrint.makeFootPrints(stairs.getNumber(), result.isRightChoice());
		map.drawMap(footPrints);
	}

	public boolean isRightStairs() {
		return result.isRightChoice();
	}

	public void changeResultToFail() {
		result.changeResultToFail();
	}

	public boolean isLose() {
		return result.isGameLose();
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry(ExitOption exitOption) {
		return exitOption.isReplay();
	}

	public Map getMap() {
		return map;
	}

	public GameResult getResult() {
		return result;
	}
}
