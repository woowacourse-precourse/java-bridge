package bridge.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.MovingResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Convertor 클래스")
class ConvertorTest {

	@Nested
	@DisplayName("convertSplitBridgeMap 메소드는")
	class Describe_convertSplitBridgeMap {

		@Nested
		@DisplayName("만약 다리 이동결과를 1개 이상 저장했다면")
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
				Convertor convertor = new Convertor();
				List<String> splitBridgeMap = convertor.convertSplitBridgeMap((List<MovingResult>) inputMovingResult);
				assertThat(splitBridgeMap).isEqualTo((List<String>) expected);
			}
		}

		@Nested
		@DisplayName("만약 다리 이동결과를 1개 저장했다면")
		class Context_save_one_moving_result {
			private List inputMovingResult = List.of(
				new MovingResult("U", true)
			);

			private List expected = List.of(
				"[ O ]",
				"[   ]"
			);

			@Test
			@DisplayName("위,아래 다리로 나누어 결과를 표시한다.")
			void it_split_bridge_map() {
				Convertor convertor = new Convertor();
				List<String> splitBridgeMap = convertor.convertSplitBridgeMap((List<MovingResult>) inputMovingResult);
				assertThat(splitBridgeMap).isEqualTo((List<String>) expected);
			}
		}
	}
}
