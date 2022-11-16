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
	InputView input = new InputView();
	OutputView out = new OutputView();
	BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
	BridgeMaker bridgeMaker = new BridgeMaker(generator);
	private String upsideBridge = "";
	private String downsideBridge = "";

	public void play() {
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(String location, List<String> bridge, int index) {
	}


	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		System.out.println(COMMAND_INPUT);
		String command = input.readGameCommand();
		if (command.equals(RETRY_GAME)) {
			return true;
		}
		return false;
	}
}

