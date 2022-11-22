package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("User 클래스")
class UserTest {
	@Nested
	@DisplayName("User 생성자는")
	class Describe_User_constructor {

		@Nested
		@DisplayName("만약 매개변수가 U,D중 하나가 아니라면")
		class Context_parameter_is_not_U_or_D {

			@DisplayName("예외를 발생시킨다.")
			@ValueSource(strings = {"A", "a", "31", "U3", " U", "U ", " "})
			@ParameterizedTest
			void it_returns_illegal_argument_exception(String input) {
				assertThatThrownBy(() -> new User(input))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("checkMoving 메소드는")
	class Describe_checkMoving {
		private List<String> inputBridge = new ArrayList<>(Arrays.asList("U", "U", "D"));

		@Nested
		@DisplayName("만약 해당 칸에 맞는 이동 방향을 선택하면")
		class Context_select_right_moving_direction {
			private List<String> movings = new ArrayList<>(Arrays.asList("U", "U", "D"));

			@Test
			@DisplayName("이동 결과가 true인 이동 결과 객체를 반환한다.")
			void it_returns_moving_result_includes_true() {
				Bridge bridge = new Bridge(inputBridge);
				movings.stream()
					.forEach(moving -> {
						User user = new User(moving);
						boolean movingResult = user.checkMoving(bridge);
						assertThat(movingResult).isTrue();
					});
			}
		}

		@Nested
		@DisplayName("만약 해당 칸에 맞지 않는 이동 방향을 선택하면")
		class Context_select_wrong_moving_direction {
			private List<String> movings = new ArrayList<>(Arrays.asList("D", "D", "U"));

			@Test
			@DisplayName("이동 결과가 false인 이동 결과 객체를 반환한다.")
			void it_returns_moving_result_includes_false() {
				Bridge bridge = new Bridge(inputBridge);
				movings.stream()
					.forEach(moving -> {
						User user = new User(moving);
						boolean movingResult = user.checkMoving(bridge);
						assertThat(movingResult).isFalse();
					});
			}
		}
	}
}
