package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.MovingResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("MovingResult 클래스")
class MovingResultTest {

	@Nested
	@DisplayName("MovingResult 생성자는")
	class Describe_MovingResult_constructor {

		@Nested
		@DisplayName("만약 매개변수인 이동방향이 U나 D가 아니라면")
		class Context_moving_direction_is_not_U_or_D {

			@DisplayName("예외를 발생시킨다.")
			@ValueSource(strings = {"A", "@", " ", "13", "ab"})
			@ParameterizedTest
			void it_returns_illegal_argument_exception(String input) {
				assertThatThrownBy(() -> new MovingResult(input, true))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("isMovingSuccess 메소드는")
	class Describe_isMovingSuccess {

		@Nested
		@DisplayName("만약 이동결과가 성공이라면")
		class Context_moving_result_success {

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult("U", true);
				assertThat(movingResult.isMovingSuccess()).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 이동결과가 싪패라면")
		class Context_moving_result_fail {

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult("D", false);
				assertThat(movingResult.isMovingSuccess()).isFalse();
			}
		}
	}

	@Nested
	@DisplayName("isMovingDirectionUp 메소드는")
	class Describe_isMovingDirectionUp {

		@Nested
		@DisplayName("만약 이동 방향이 위라면")
		class Context_moving_direction_up {

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult("U", true);
				assertThat(movingResult.isMovingDirectionUp()).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 이동방향이 아래라면")
		class Context_moving_direction_down {

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult("D", false);
				assertThat(movingResult.isMovingDirectionUp()).isFalse();
			}
		}
	}

	@Nested
	@DisplayName("isMovingDirectionDown 메소드는")
	class Describe_isMovingDirectionDown {

		@Nested
		@DisplayName("만약 이동 방향이 위라면")
		class Context_moving_direction_up {

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult("U", true);
				assertThat(movingResult.isMovingDirectionDown()).isFalse();
			}
		}

		@Nested
		@DisplayName("만약 이동방향이 아래라면")
		class Context_moving_direction_down {

			@Test
			@DisplayName("true 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult("D", false);
				assertThat(movingResult.isMovingDirectionDown()).isTrue();
			}
		}
	}
}
