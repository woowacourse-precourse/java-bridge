package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Constants;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Bridge 클래스")
public class BridgeTest {

	@DisplayName("다리 길이가 3 보다 작거나 20 보다 크면 예외가 발생한다.")
	@ParameterizedTest(name = "다리길이 : {0} , 예외 발생 예상 : {1}")
	@CsvSource({"2, true", "3, false", "20, false", "21, true"})
	void bridge_length_exception_text(int length, boolean hasException) {
		List<String> inputBridge = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			inputBridge.add("U");
		}
		if (hasException) {
			assertThatThrownBy(() -> new Bridge(inputBridge))
				.isInstanceOf(IllegalArgumentException.class);
		}
		if (!hasException) {
			Bridge bridge = new Bridge(inputBridge);
			assertThat(bridge).isNotNull();
		}
	}

	@DisplayName("위치 당 위, 아래 중 하나만 건널 수 있다. 샘플 : 'UDU'")
	@ParameterizedTest(name = "위치 : {0} , 예상 : {1}")
	@CsvSource({"1, true", "2, false", "3, true"})
	void bridge_plate_test(int position, boolean expected) {
		//given
		Bridge bridge = new Bridge(List.of("U", "D", "U"));
		//when
		boolean actual = bridge.canWalk(position, Constants.UP);
		//then
		assertThat(actual).isEqualTo(expected);
	}

	@Nested
	@DisplayName("다리가 'UDU' 일 때")
	class Describe_canWalk {

		Bridge bridge = new Bridge(List.of("U", "D", "U"));

		@Nested
		@DisplayName("다리의 위치가 유효할 경우")
		class Context_Validate_Position {

			@DisplayName("해당 위치의 다리가 U라면 true 반환")
			@ParameterizedTest(name = "위치 : {0} , 예상 반환 : {1}")
			@CsvSource({"1, true", "2, false", "3, true"})
			void it_returns_boolean(int position, boolean expected) {
				//when
				boolean actual = bridge.canWalk(position, Constants.UP);
				//then
				assertThat(actual).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("다리의 위치가 유효하지 않은 경우")
		class Context_Invalidate_Position {

			@DisplayName("IllegalArgumentException 반환")
			@ParameterizedTest(name = "위치 : {0}")
			@CsvSource({"0", "4"})
			void it_throws_IllegalArgumentException(int position) {
				assertThatThrownBy(() -> bridge.canWalk(position, Constants.UP))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}
