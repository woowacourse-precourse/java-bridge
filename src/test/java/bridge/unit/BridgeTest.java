package bridge.unit;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import bridge.Application;
import bridge.service.BridgeGame;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;

public class BridgeTest extends NsTest {

	@Test
	void 다리_출력_테스트() {
		OutputView outputView = new OutputView();
		outputView.printMap(List.of("U", "D", "U"), List.of("U", "D", "U"));
		assertThat(output()).contains(
			"[ O |   | O ]",
			"[   | O |   ]"
		);
	}

	@Test
	void 다리_출력_테스트_입력리스트의_길이가_더_짧을_경우() {
		OutputView outputView = new OutputView();
		outputView.printMap(List.of("U", "D", "U"), List.of("U", "D"));
		assertThat(output()).contains(
			"[ O |   ]",
			"[   | O ]"
		);
	}

	@Test
	void 최종_다리_출력_테스트() {
		OutputView outputView = new OutputView();
		outputView.printFinalMapResult(List.of("U", "D", "U", "U"), List.of("U", "D", "U", "U"));
		assertThat(output()).contains(
			"[ O |   | O | O ]",
			"[   | O |   |   ]"
		);
	}

	@Test
	void 이동_테스트() {
		BridgeGame bridgeGame = new BridgeGame();
		List<String> currentBridgeState = new ArrayList<>(List.of("U", "D", "U"));
		bridgeGame.move(currentBridgeState, "U");

		assertThat(currentBridgeState.containsAll(List.of("U", "D", "U", "U"))).isTrue();
	}

	@Test
	void 게임_종료테스트() {
		BridgeGame bridgeGame = new BridgeGame();
		assertThat(bridgeGame.retry("R")).isTrue();
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}

}
