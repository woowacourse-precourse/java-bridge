package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {

	@Nested
	@DisplayName("성공 테스트 클래스")
	class SuccessTest {

		@Test
		@DisplayName("다리의 상태를 확인하는 테스트. (0은 아래칸(D), 1은 윗칸(U))")
		void correctBridgeStateTest() {

			// given
			BridgeNumberGenerator bridgeFixNumberGenerator = new BridgeFixNumberGenerator(
					newArrayList(1, 1, 0, 0, 1, 0, 1));
			BridgeMaker bridgeMaker = new BridgeMaker(bridgeFixNumberGenerator);

			// when
			List<String> bridge = bridgeMaker.makeBridge(7);

			// then
			assertThat(bridge).containsExactly("U", "U", "D", "D", "U", "D", "U");
		}
	}

	@Nested
	@DisplayName("예외상황 테스트 클래스")
	class FailTest {

		@Test
		@DisplayName("다리의 상태를 확인하는 테스트. (0은 아래칸(D), 1은 윗칸(U))")
		void wrongBridgeStateTest() {

			// given
			BridgeNumberGenerator bridgeFixNumberGenerator = new BridgeFixNumberGenerator(
					newArrayList(1, 0, 1, 1, 1, 0, 0));
			BridgeMaker bridgeMaker = new BridgeMaker(bridgeFixNumberGenerator);

			// when
			List<String> bridge = bridgeMaker.makeBridge(7);
			String actuallyDButU = "U";
			String wrongState = "A";

			// then
			assertThat(bridge).doesNotContainSequence("U", wrongState, "U", "U", "U", actuallyDButU, "D");
		}

		@Test
		@DisplayName("다리 생성 시 랜덤값 유효성 검사 기능을 확인하는 테스트")
		void validateRandomNumberTest() {

			// given
			BridgeNumberGenerator bridgeFixNumberGenerator = new BridgeFixNumberGenerator(
					newArrayList(1, 1, 1, 1, -1, 2, 0));
			BridgeMaker bridgeMaker = new BridgeMaker(bridgeFixNumberGenerator);

			// when
			String expectedExceptionMessage = BridgeState.DOWN.getBridgeStateErrorMessage();

			// then
			assertThatThrownBy(() -> bridgeMaker.makeBridge(7)).hasMessageContaining(expectedExceptionMessage);
		}
	}

	static class BridgeFixNumberGenerator implements BridgeNumberGenerator {

		private final List<Integer> fixedBridgeNumbers;

		BridgeFixNumberGenerator(List<Integer> fixedBridgeNumbers) {
			this.fixedBridgeNumbers = fixedBridgeNumbers;
		}

		@Override
		public int generate() {
			return fixedBridgeNumbers.remove(0);
		}

	}
}
