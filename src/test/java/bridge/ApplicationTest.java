package bridge;

import bridge.model.BridgeMaker;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) class ApplicationTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	@Order(1) @Test void 다리_생성_테스트() {
		BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(3);
		assertThat(bridge).containsExactly("U", "D", "D");
	}

	@Order(2) @Test void 다리_생성_테스트2() {
		BridgeNumberGenerator numberGenerator =
			new TestNumberGenerator(newArrayList(1, 0, 1, 0, 1));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(5);
		assertThat(bridge).containsExactly("U", "D", "U", "D", "U");
	}

	@Order(3) @Test void 기능_테스트() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "U", "D", "U");
			assertThat(output()).contains("최종 게임 결과", "[ O |   | O ]", "[   | O |   ]",
				"게임 성공 여부: 성공", "총 시도한 횟수: 1");

			int upSideIndex = output().indexOf("[ O |   | O ]");
			int downSideIndex = output().indexOf("[   | O |   ]");
			assertThat(upSideIndex).isLessThan(downSideIndex);
		}, 1, 0, 1);
	}
	@Order(4)
	@Test void 기능_테스트2() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "U", "D", "D", "R", "U", "D", "U");
			assertThat(output()).contains("[ O |   |   ]", "[   | O | X ]", "최종 게임 결과",
				"[ O |   | O ]", "[   | O |   ]", "게임 성공 여부: 성공", "총 시도한 횟수: 2");

			int upSideIndex = output().indexOf("[ O |   | O ]");
			int downSideIndex = output().indexOf("[   | O |   ]");
			assertThat(upSideIndex).isLessThan(downSideIndex);
		}, 1, 0, 1);
	}
	@Order(5)
	@Test void 기능_테스트3() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "U", "D", "D", "Q");
			assertThat(output()).contains("최종 게임 결과", "[ O |   |   ]", "[   | O | X ]",
				"게임 성공 여부: 실패", "총 시도한 횟수: 1");

			int upSideIndex = output().indexOf("[ O |   |   ]");
			int downSideIndex = output().indexOf("[   | O | X ]");
			assertThat(upSideIndex).isLessThan(downSideIndex);
		}, 1, 0, 1);
	}
	@Order(6)
	@Test void 예외_테스트() {
		assertSimpleTest(() -> {
			runException("a");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}
	@Order(7)
	@Test void 예외_테스트1() {
		assertSimpleTest(() -> {
			runException(" ");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("!@#$");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("btrhf");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}
	@Order(8)
	@Test void 예외_테스트2() {
		assertSimpleTest(() -> {
			runException("3", "Q", "R");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("3", "Q", "#@$%");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("3", "Q", "");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("3", "Q", "12314");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}
	@Order(9)
	@Test void 예외_테스트3() {
		assertSimpleTest(() -> {
			runException("3", "U", "U", "U", "F");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("3", "U", "U", "U", "vbwsq");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("3", "U", "U", "U", "");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("3", "U", "U", "U", "-1");
			assertThat(output()).contains(ERROR_MESSAGE);
		});

		assertSimpleTest(() -> {
			runException("3", "U", "U", "U", "1243546");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Override protected void runMain() {
		Application.main(new String[] {});
	}

	static class TestNumberGenerator implements BridgeNumberGenerator {

		private final List<Integer> numbers;

		TestNumberGenerator(List<Integer> numbers) {
			this.numbers = numbers;
		}

		@Override public int generate() {
			return numbers.remove(0);
		}
	}
}
