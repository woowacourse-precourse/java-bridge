package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeMap 클래스")
class BridgeMapTest {
	@Nested
	@DisplayName("getMovingResult 메소드는")
	class Describe_getMovingResult {

		@Nested
		@DisplayName("만약 이동결과가 성공이라면")
		class Context_moving_Result_success {
			private MovingResult movingResult = new MovingResult("U", true);

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				BridgeMap bridgeMap = new BridgeMap();
				bridgeMap.addMovingResult(movingResult);
				assertThat(bridgeMap.getMovingResult()).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 이동결과가 실라면")
		class Context_moving_Result_fail {
			private MovingResult movingResult = new MovingResult("U", false);

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_false() {
				BridgeMap bridgeMap = new BridgeMap();
				bridgeMap.addMovingResult(movingResult);
				assertThat(bridgeMap.getMovingResult()).isFalse();
			}
		}
	}

	@Nested
	@DisplayName("getSplitMap 메소드는")
	class Describe_getSplitMap {

		@Nested
		@DisplayName("만약 이동결과를 1개 이상 저장했다면")
		class Context_save_more_than_one_of_moving_results {
			private List inputMovingResult = List.of(
				new MovingResult("U", true),
				new MovingResult("D", false),
				new MovingResult("U", true)
			);

			private List expected = List.of(
				"[ O |   | O ]",
				"[   | X |   ]"
			);

			@Test
			@DisplayName("다리 이동결과를 |로 나누어 결과를 표시하며 위,아래 다리로 나누어 결과를 표시한다.")
			void it_returns_split_bridge_map() {
				BridgeMap bridgeMap = new BridgeMap();
				inputMovingResult.stream()
					.forEach(movingResult -> bridgeMap.addMovingResult((MovingResult) movingResult));
				List<String> splitBridgeMap = bridgeMap.getSplitMap();
				assertThat(splitBridgeMap).isEqualTo((List<String>) expected);
			}
		}

		@Nested
		@DisplayName("만약 이동결과를 1개 저장했다면")
		class Context_save_moving_result_one {
			private List inputMovingResult = List.of(
				new MovingResult("U", true)
			);

			private List expected = List.of(
				"[ O ]",
				"[   ]"
			);

			@Test
			@DisplayName("위,아래 다리로 나누어 결과를 표시한다.")
			void it_returns_split_bridge_map() {
				BridgeMap bridgeMap = new BridgeMap();
				inputMovingResult.stream()
					.forEach(movingResult -> bridgeMap.addMovingResult((MovingResult) movingResult));
				List<String> splitBridgeMap = bridgeMap.getSplitMap();
				assertThat(splitBridgeMap).isEqualTo((List<String>) expected);
			}
		}

		@Nested
		@DisplayName("만약 이동결과를 저장한 적이 없다면")
		class Context_never_save_moving_results {

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				BridgeMap bridgeMap = new BridgeMap();
				assertThatThrownBy(() -> bridgeMap.getSplitMap())
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}
