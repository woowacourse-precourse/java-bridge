package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import org.junit.jupiter.api.Test;

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
	void 다리_사이즈_범위_테스트() {
		assertSimpleTest(() -> {
			runException("21");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void moving_예외_U_D_테스트() {
		assertSimpleTest(() -> {
			runException("3", "U", "D", "W");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void moving_예외_알파벳_테스트() {
		assertSimpleTest(() -> {
			runException("3", "U", "D", "1");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void retry_예외_R_Q_테스트() {
		assertRandomNumberInRangeTest(() -> {
			runException("3", "U", "D", "D", "T");
			assertThat(output()).contains(ERROR_MESSAGE);
		}, 1, 0, 1);
	}

	@Test
	void retry_예외_알파벳_테스트() {
		assertRandomNumberInRangeTest(() -> {
			runException("3", "U", "D", "D", "1");
			assertThat(output()).contains(ERROR_MESSAGE);
		}, 1, 0, 1);
	}

	@Test
	void 시도_횟수_검사() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "U", "D", "D", "R", "U", "D", "U");
			assertThat(output()).contains("총 시도한 횟수: 2");
		}, 1, 0, 1);
	}

	@Test
	void retry_R_기능_테스트() {
		BridgeGame bridgeGame = new BridgeGame();
		assertThat(true).isEqualTo(bridgeGame.retry("R"));
	}

	@Test
	void retry_Q_기능_테스트() {
		BridgeGame bridgeGame = new BridgeGame();
		assertThat(false).isEqualTo(bridgeGame.retry("Q"));
	}

	@Test
	void move_U_기능_테스트() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "U", "U", "U");
			assertThat(output()).contains(
				"최종 게임 결과",
				"[ O | O | O ]",
				"[   |   |   ]",
				"게임 성공 여부: 성공",
				"총 시도한 횟수: 1"
			);
			int upSideIndex = output().indexOf("[ O ]");
			int downSideIndex = output().indexOf("[   ]");
			assertThat(upSideIndex).isLessThan(downSideIndex);
		}, 1, 1, 1);
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
