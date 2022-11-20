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
			@DisplayName("이동 결과 사이에 |로 나누어 분할한다.")
			void it_returns_converted_moving_results() {
				BridgeMap bridgeMap = new BridgeMap();
				inputMovingResult.stream()
					.forEach(movingResult -> bridgeMap.addMovingResult((MovingResult) movingResult));
				List<String> splitBridgeMap = bridgeMap.getSplitMap();

				assertThat(splitBridgeMap).isEqualTo((List<String>) expected);
			}
		}

		@Nested
		@DisplayName("만약 이동결과를 1개 저장했다면")
		class Context_save_one_of_moving_result {
			private List inputMovingResult = List.of(
				new MovingResult("U", true)
			);

			private List expected = List.of(
				"[ O ]",
				"[   ]"
			);

			@Test
			@DisplayName("이동 결과 사이에 나누는거 없이 분할한다.")
			void it_returns_converted_moving_results() {
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
