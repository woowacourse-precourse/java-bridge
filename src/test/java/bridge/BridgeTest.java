package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.enums.Inputs;

class BridgeTest {

	private Bridge alternativeBridge;
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
		alternativeBridge = new Bridge(bridgeLength, new BridgeAlternativeNumberGenerator());
	}

	@DisplayName("정답이 교대인 다리를 정상적으로 이동해야 한다.")
	@Test
	void moveNextTest() {
		assertTrue(alternativeBridge.moveNext(Inputs.MOVE_UP));
		assertFalse(alternativeBridge.moveNext(Inputs.MOVE_UP));
		assertTrue(alternativeBridge.moveNext(Inputs.MOVE_DOWN));
		assertTrue(alternativeBridge.moveNext(Inputs.MOVE_UP));
	}

	@DisplayName("게임 승리 여부에 대한 상태를 반환해야 한다")
	@Test
	void gameWonTest() {
		alternativeBridge.moveNext(Inputs.MOVE_UP);
		alternativeBridge.moveNext(Inputs.MOVE_DOWN);
		alternativeBridge.moveNext(Inputs.MOVE_UP);
		alternativeBridge.moveNext(Inputs.MOVE_UP);
		assertFalse(alternativeBridge.gameWon());
		alternativeBridge.moveNext(Inputs.MOVE_DOWN);
		assertTrue(alternativeBridge.gameWon());
	}

	// @DisplayName("위쪽으로만 이동이 가능한 길이 5의 다리가 생성되어야 한다")
	// @ParameterizedTest
	// @MethodSource("moveAndExpectedSrc")
	// void moveNextTest(Inputs move, boolean isSuccess, List<Integer> expected) {
	// 	Assertions.assertThat(upMovableLength10Bridge.moveNext(move)).isEqualTo(isSuccess);
	// 	Assertions.assertThat(upMovableLength10Bridge.getSuccessfullyMovedPartialBridge()).isEqualTo(expected);
	// }
	//
	// private static Stream<Arguments> moveAndExpectedSrc() {
	// 	return Stream.of(
	// 		Arguments.of(Inputs.MOVE_UP, true, List.of("U")),
	// 		Arguments.of(Inputs.MOVE_UP, true, List.of("U", "U")),
	// 		Arguments.of(Inputs.MOVE_DOWN, false, List.of("U", "U")),
	// 		Arguments.of(Inputs.MOVE_UP, true, List.of("U", "U", "U")),
	// 		Arguments.of(Inputs.MOVE_UP, true, List.of("U", "U", "U", "U")),
	// 		Arguments.of(Inputs.MOVE_UP, true, List.of("U", "U", "U", "U", "U"))
	// 	);
	// }
}
