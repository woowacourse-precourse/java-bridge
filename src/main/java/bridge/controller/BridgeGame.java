package bridge.controller;

import static bridge.controller.Constant.*;

import java.util.List;

import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
	BridgeMaker bridgeMaker = new BridgeMaker(generator);
	private String upsideBridge = "";
	private String downsideBridge = "";

	public void play() {
		List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
		System.out.println(START_MESSAGE);

		controlMove(bridge);
	}

	private void controlMove(List<String> bridge) {
		for (int i = 0; i < bridge.size(); i++) {
			String location = InputView.readMoving();
			move(location, bridge, i);
			OutputView.printMap(upsideBridge);
			OutputView.printMap(downsideBridge);
		}
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(String location, List<String> bridge, int index) {
		setUpsideBridge(location, bridge, index);
		setDownsideBridge(location, bridge, index);
	}

	private void setDownsideBridge(String location, List<String> bridge, int index) {
		if (location.equals(DOWNSIDE) && location.equals(bridge.get(index))) {
			upsideBridge += (SEPARATOR + BLANK);
			downsideBridge += (SEPARATOR + RIGHT);
		}
		if (location.equals(DOWNSIDE) && !location.equals(bridge.get(index))) {
			upsideBridge += (SEPARATOR + BLANK);
			downsideBridge += (SEPARATOR + WRONG);
			retry();
		}
	}

	private void setUpsideBridge(String location, List<String> bridge, int index) {
		if (location.equals(UPSIDE) && location.equals(bridge.get(index))) {
			upsideBridge += (SEPARATOR + RIGHT);
			downsideBridge += (SEPARATOR + BLANK);
		}
		if (location.equals(UPSIDE) && !location.equals(bridge.get(index))) {
			upsideBridge += (SEPARATOR + WRONG);
			downsideBridge += (SEPARATOR + BLANK);
			retry();
		}
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		String command = InputView.readGameCommand();
		if (command.equals(RETRY_GAME)) {
			return true;
		}
		return false;
	}
}

