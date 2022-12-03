package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.dto.Moving;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("User 클래스")
class UserTest {

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
					.forEach(input -> {
						Moving moving = new Moving(input);
						User user = new User(bridge);
						boolean movingResult = user.checkMoving(moving);
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
					.forEach(input -> {
						Moving moving = new Moving(input);
						User user = new User(bridge);
						boolean movingResult = user.checkMoving(moving);
						assertThat(movingResult).isFalse();
					});
			}
		}
	}

	@Nested
	@DisplayName("isKeepMove 메소드는")
	class Describe_isKeepMove {
		private List<String> InputBridge = new ArrayList<>(Arrays.asList("U", "D", "U"));

		@Nested
		@DisplayName("만약 다리의 모든 칸을 건너면")
		class Context_cross_bridge {
			List<String> userMoving = new ArrayList<>(Arrays.asList("U", "D", "U"));

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				Bridge bridge = new Bridge(InputBridge);
				User user = new User(bridge);
				userMoving.stream()
					.forEach(direction -> {
						bridge.checkUserMoving(direction);
					});

				assertThat(user.isKeepMove()).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 다리의 모든 칸을 건너지 못하면")
		class Context_not_cross_bridge {
			List<String> userMoving = new ArrayList<>(Arrays.asList("U", "U"));

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				Bridge bridge = new Bridge(InputBridge);
				User user = new User(bridge);
				userMoving.stream()
					.forEach(direction -> {
						bridge.checkUserMoving(direction);
					});

				assertThat(user.isKeepMove()).isFalse();
			}
		}
	}
}
