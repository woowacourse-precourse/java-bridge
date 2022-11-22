package bridge.domain.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.dto.BridgeSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BridgeSize 클래스")
class BridgeSizeTest {

	@Nested
	@DisplayName("BridgeSize 생성자는")
	class Describe_BridgeSize_constructor {

		@Nested
		@DisplayName("매개변수가 3~20 사이의 문자라면")
		class Context_parameter_is_valid_number {

			@DisplayName("해당 문자를 숫자로 변환해서 저장한다.")
			@ValueSource(strings = {"3", "20", "4", "18"})
			@ParameterizedTest
			void it_convert_Integer_and_save(String input) {
				BridgeSize bridgeSize = new BridgeSize(input);
				int expected = Integer.parseInt(input);
				assertThat(bridgeSize.getSize()).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("매개변수가 숫자가 아닌 다른 문자라면")
		class Context_parameter_is_not_number {

			@DisplayName("예외를 발생시킨다.")
			@ValueSource(strings = {"a", "@", " ", "3a"})
			@ParameterizedTest
			void it_returns_illegal_argument_exception(String input) {
				assertThatThrownBy(() -> new BridgeSize(input))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("매개변수가 3과 20 사이의 숫자가 아니면")
		class Context_parameter_is_not_restricted_range_number {

			@DisplayName("예외를 발생시킨다.")
			@ValueSource(strings = {"1", "2", "21", "100", "-3"})
			@ParameterizedTest
			void it_returns_illegal_argument_exception(String input) {
				assertThatThrownBy(() -> new BridgeSize(input))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("매개변수가 두자리이며 첫째자리가 1미만이면")
		class Context_parameter_is_double_digit_and_first_digit_zero {

			@DisplayName("예외를 발생시킨다.")
			@ValueSource(strings = {"01", "02", "04", "021"})
			@ParameterizedTest
			void it_returns_illegal_argument_exception(String input) {
				assertThatThrownBy(() -> new BridgeSize(input))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}
