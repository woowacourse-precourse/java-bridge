package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class BridgeTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 성공_유무_검사() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "U", "D", "U");
			assertThat(output()).contains("게임 성공 여부: 성공");
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
	void move_기능테스트() {
		assertRandomNumberInRangeTest(() -> {
			BridgeGame bridgeGame = new BridgeGame();
			bridgeGame.setBridge(3);
			assertThat(true).isEqualTo(bridgeGame.move("U", 0));
		}, 1, 0, 1);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}