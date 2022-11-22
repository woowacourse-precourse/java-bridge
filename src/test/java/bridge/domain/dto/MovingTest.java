package bridge.domain.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.dto.Moving;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Moving 클래스")
class MovingTest {

	@Nested
	@DisplayName("Moving 생성자는")
	class Describe_Moving_constructor {

		@Nested
		@DisplayName("매개변수가 U와 D중 하나의 문자라면")
		class Context_parameter_is_U_or_D {

			@DisplayName("해당 문자를 저장한다.")
			@ValueSource(strings = {"U", "D"})
			@ParameterizedTest
			void it_save_parameter(String input) {
				Moving moving = new Moving(input);
				String expected = input;
				assertThat(moving.getMoving()).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("매개변수가 U와 D중 하나가 아니라면")
		class Context_parameter_is_not_U_or_D {

			@DisplayName("예외를 발생시킨다.")
			@ValueSource(strings = {"A", "@", " ", "13", "ab"})
			@ParameterizedTest
			void it_returns_illegal_argument_exception(String input) {
				assertThatThrownBy(() -> new Moving(input))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}
