package bridge.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.MovingResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Convertor 클래스")
class ConvertorTest {
	private Convertor convertor = new Convertor();

	@Nested
	@DisplayName("convertMovingDirection 메소드는")
	class Describe_convertMovingDirection {

		@Nested
		@DisplayName("만약 매개변수 숫자가 0이면")
		class Context_parameter_is_zero {
			private int number = 0;
			private String expected = "D";

			@Test
			@DisplayName("D를 반환한다.")
			void it_returns_D() {
				String direction = Convertor.convertMovingDirection(number);
				assertThat(direction).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("만약 매개변수 숫자가 1이면")
		class Context_parameter_is_one {
			private int number = 1;
			private String expected = "U";

			@Test
			@DisplayName("U를 반환한다.")
			void it_returns_D() {
				String direction = Convertor.convertMovingDirection(number);
				assertThat(direction).isEqualTo(expected);
			}
		}
	}

	@Nested
	@DisplayName("convertSuccessOrFail 메소드는")
	class Describe_convertSuccessOrFail {
		private final String SUCCESS = "성공";
		private final String FAIL = "실패";

		@Nested
		@DisplayName("만약 매개변수가 true이면")
		class Context_parameter_is_true {
			boolean isSuccess = true;
			String expected = SUCCESS;

			@Test
			@DisplayName("성공을 반환한다.")
			void it_returns_success() {
				String successOrFail = convertor.convertSuccessOrFail(isSuccess);
				assertThat(successOrFail).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("만약 매개변수가 false이면")
		class Context_parameter_is_false {
			boolean isSuccess = false;
			String expected = FAIL;

			@Test
			@DisplayName("실패를 반환한다.")
			void it_returns_fail() {
				String successOrFail = convertor.convertSuccessOrFail(isSuccess);
				assertThat(successOrFail).isEqualTo(expected);
			}
		}
	}

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
				List<String> splitBridgeMap = convertor.convertSplitBridgeMap((List<MovingResult>) inputMovingResult);
				assertThat(splitBridgeMap).isEqualTo((List<String>) expected);
			}
		}
	}
}
