package bridge.domain.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.dto.GameCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("GameCommand 클래스")
class GameCommandTest {

	@Nested
	@DisplayName("GameCommand 생성자는")
	class Describe_GameCommand_constructor {

		@Nested
		@DisplayName("매개변수가 R와 Q중 하나의 문자라면")
		class Context_parameter_is_R_or_Q {

			@DisplayName("해당 문자를 저장한다.")
			@ValueSource(strings = {"R", "Q"})
			@ParameterizedTest
			void it_save_parameter(String input) {
				GameCommand gameCommand = new GameCommand(input);
				String expected = input;
				assertThat(gameCommand.getCommand()).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("매개변수가 R와 Q중 하나가 아니라면")
		class Context_parameter_is_not_R_or_Q {

			@DisplayName("예외를 발생시킨다.")
			@ValueSource(strings = {"A", "@", " ", "13", "ab"})
			@ParameterizedTest
			void it_returns_illegal_argument_exception(String input) {
				assertThatThrownBy(() -> new GameCommand(input))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}

