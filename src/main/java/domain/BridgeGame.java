package domain;

import java.util.List;

import bridge.BridgeRandomNumberGenerator;
import service.InputView;
import service.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	InputView in = new InputView();
	OutputView out = new OutputView();
	private final List<String> bridge;

	private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

	private MapMaker mapMaker = new MapMaker();
	private int gameCount = 0;

	public BridgeGame() {
		bridge = start();
		move(bridge);
	}

	public List<String> start() {
		out.printGameMessage("START");
		out.printGameMessage("BRIDGE_SIZE");
		int size = in.readBridgeSize();

		return bridgeMaker.makeBridge(size);
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(List<String> bridge) {
		gameCount++;

		for (String rightCondition : bridge) {
			if (!failCheck(rightCondition)) {
				break;
			}
		}

		ending(true);
	}

	public boolean failCheck(String rightCondition) {
		if (!mapMaker.conditionCheck(rightCondition)) {
			retry();
			return false;
		}

		return true;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		out.printGameMessage("COMMAND");
		String command = in.readGameCommand();

		if(command.equals("R")) {
			mapMaker = new MapMaker();
			move(bridge);
		}

		ending(false);
		return;
	}

	public void ending(boolean gameResult) {
		String result = "성공";

		if (!gameResult) {
			result = "실패";
		}

		out.printResult(mapMaker.toString(), result, gameCount);
		return;
	}

}
