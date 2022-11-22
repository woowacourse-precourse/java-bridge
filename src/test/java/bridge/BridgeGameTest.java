package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import bridge.enums.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

	private BridgeGame alternativeBridge;
	private int bridgeLength = 4;

	private static class BridgeAlternativeNumberGenerator implements BridgeNumberGenerator {
		private boolean one = false;
		@Override
		public int generate() {
			one = !one;
			if (one) {
				return 1;
			}
			return 0;
		}
	}

	@BeforeEach
	void beforeEach() {
		alternativeBridge = new BridgeGame(bridgeLength, new BridgeAlternativeNumberGenerator());
	}

	@DisplayName("정답이 교대인 다리를 정상적으로 이동해야 한다.")
	@Test
	void moveNextTest() {
		assertTrue(alternativeBridge.move(Inputs.MOVE_UP));
		assertFalse(alternativeBridge.move(Inputs.MOVE_UP));
		assertTrue(alternativeBridge.move(Inputs.MOVE_DOWN));
		assertTrue(alternativeBridge.move(Inputs.MOVE_UP));
	}

	@DisplayName("게임 승리 여부에 대한 상태를 반환해야 한다.")
	@Test
	void gameWonTest() {
		alternativeBridge.move(Inputs.MOVE_UP);
		alternativeBridge.move(Inputs.MOVE_DOWN);
		alternativeBridge.move(Inputs.MOVE_UP);
		alternativeBridge.move(Inputs.MOVE_UP);
		assertFalse(alternativeBridge.gameWon());
		alternativeBridge.move(Inputs.MOVE_DOWN);
		assertTrue(alternativeBridge.gameWon());
	}

	@DisplayName("진행 상황이 초기화되어야 한다.")
	@Test
	void resetMoveStatusTest() {
		alternativeBridge.move(Inputs.MOVE_UP);
		assertThat(alternativeBridge.toString()).isEqualTo("[ O ]\n[   ]");
		alternativeBridge.retry();
		assertThat(alternativeBridge.toString()).isEqualTo("]\n]");
	}

	@Nested
	class toStringTest {
		@DisplayName("진행 상황을 문자열로 반환해야 한다.")
		@Test
		void toStringTest1() {
			alternativeBridge.move(Inputs.MOVE_UP);
			alternativeBridge.move(Inputs.MOVE_DOWN);
			String result = "[ O |   ]\n[   | O ]";
			assertThat(alternativeBridge.toString()).isEqualTo(result);
		}

		@DisplayName("실패한 상황 또한 문자열로 표현되어야 한다.")
		@Test
		void toStringTest2() {
			alternativeBridge.move(Inputs.MOVE_UP);
			alternativeBridge.move(Inputs.MOVE_DOWN);
			alternativeBridge.move(Inputs.MOVE_DOWN);
			String result = "[ O |   |   ]\n[   | O | X ]";
			assertThat(alternativeBridge.toString()).isEqualTo(result);
		}
	}

	@DisplayName("다리 초기화 시 시도 횟수가 증가해야 한다.")
	@Test
	void getTrialsTest() {
		assertThat(alternativeBridge.getTrials()).isEqualTo(1);
		alternativeBridge.retry();
		assertThat(alternativeBridge.getTrials()).isEqualTo(2);
	}
}
