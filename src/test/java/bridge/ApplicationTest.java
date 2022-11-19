package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import bridge.repository.BridgeMaker;
import bridge.service.BridgeGame;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 다리_생성_테스트() {
		BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(3);
		assertThat(bridge).containsExactly("U", "D", "D");
	}

	@Test
	void 기능_테스트() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "U", "D", "U");
			assertThat(output()).contains(
				"최종 게임 결과",
				"[ O |   | O ]",
				"[   | O |   ]",
				"게임 성공 여부: 성공",
				"총 시도한 횟수: 1"
			);

			int upSideIndex = output().indexOf("[ O |   | O ]");
			int downSideIndex = output().indexOf("[   | O |   ]");
			assertThat(upSideIndex).isLessThan(downSideIndex);
		}, 1, 0, 1);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() -> {
			runException("a");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

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

	static class TestNumberGenerator implements BridgeNumberGenerator {

		private final List<Integer> numbers;

		TestNumberGenerator(List<Integer> numbers) {
			this.numbers = numbers;
		}

		@Override
		public int generate() {
			return numbers.remove(0);
		}
	}
}
