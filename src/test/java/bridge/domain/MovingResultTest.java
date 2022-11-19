package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("MovingResult 클래스")
class MovingResultTest {
	private final String MOVING_DIRECTION_UP = "U";
	private final String MOVING_DIRECTION_DOWN = "D";

	@Nested
	@DisplayName("isMovingSuccess 메소드는")
	class Describe_isMovingSuccess {

		@Nested
		@DisplayName("만약 이동결과가 성공이라면")
		class Context_moving_result_success {

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult(MOVING_DIRECTION_UP, true);
				assertThat(movingResult.isMovingSuccess()).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 이동결과가 싪패라면")
		class Context_moving_result_fail {

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult(MOVING_DIRECTION_DOWN, false);
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
				MovingResult movingResult = new MovingResult(MOVING_DIRECTION_UP, true);
				assertThat(movingResult.isMovingDirectionUp()).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 이동방향이 아래라면")
		class Context_moving_direction_down {

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult(MOVING_DIRECTION_DOWN, false);
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
				MovingResult movingResult = new MovingResult(MOVING_DIRECTION_UP, true);
				assertThat(movingResult.isMovingDirectionDown()).isFalse();
			}
		}

		@Nested
		@DisplayName("만약 이동방향이 아래라면")
		class Context_moving_direction_down {

			@Test
			@DisplayName("true 반환한다.")
			void it_returns_true() {
				MovingResult movingResult = new MovingResult(MOVING_DIRECTION_DOWN, false);
				assertThat(movingResult.isMovingDirectionDown()).isTrue();
			}
		}
	}
}
