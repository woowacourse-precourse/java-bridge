package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Bridge 클래스")
class BridgeTest {
	@Nested
	@DisplayName("Bridge 생성자는")
	class Describe_Bridge_constructor {
		@Nested
		@DisplayName("만약 다리칸 중에서 U나 D가 아닌게 있다면")
		class Context_bridge_includes_not_U_or_D {
			List inputBridgeList = List.of(
				List.of("U", "D", "R"),
				List.of("U", "D", " "),
				List.of("U", "D", "5"),
				List.of("U", "D", "D@")
			);

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				inputBridgeList.stream()
					.forEach(inputBridge -> {
						assertThatThrownBy(() -> new Bridge((List<String>) inputBridge))
							.isInstanceOf(IllegalArgumentException.class);
					});
			}
		}

		@Nested
		@DisplayName("만약 다리의 길이가 3-20사이가 아니라면")
		class Context_bridge_size_boundary_not_three_to_twenty {
			List inputBridgeList = List.of(
				List.of("U", "D"),
				List.of("U", "D", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
					"U", "U", "U", "U")
			);

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				inputBridgeList.stream()
					.forEach(inputBridge -> {
						assertThatThrownBy(() -> new Bridge((List<String>) inputBridge))
							.isInstanceOf(IllegalArgumentException.class);
					});
			}
		}
	}

	@Nested
	@DisplayName("checkUserMoving 메소드는")
	class Describe_checkUserMoving {
		private List<String> InputBridge = new ArrayList<>(Arrays.asList("U", "D", "U"));

		@Nested
		@DisplayName("만약 이동할 방향과 해당 다리 칸의 방향이 일치하지 않으면")
		class Context_user_moving_and_bridge_are_not_correct {
			List<String> userMoving = new ArrayList<>(Arrays.asList("D", "U", "D"));

			@Test
			@DisplayName("이동실패를 반환한다.")
			void it_returns_moving_result_include_result_false() {
				Bridge bridge = new Bridge(InputBridge);
				userMoving.stream()
					.forEach(direction -> {
						MovingResult movingResult = bridge.checkUserMoving(direction);
						assertThat(movingResult.isMovingSuccess()).isFalse();
					});
			}
		}

		@Nested
		@DisplayName("만약 이동할 방향과 해당 다리 칸의 방향이 일치하면")
		class Context_user_moving_and_bridge_are_correct {
			List<String> userMoving = new ArrayList<>(Arrays.asList("U", "D", "U"));

			@Test
			@DisplayName("이동성공을 반환한다.")
			void it_returns_moving_result_include_result_true() {
				Bridge bridge = new Bridge(InputBridge);
				userMoving.stream()
					.forEach(direction -> {
						MovingResult movingResult = bridge.checkUserMoving(direction);
						assertThat(movingResult.isMovingSuccess()).isTrue();
					});
			}
		}
	}

	@Nested
	@DisplayName("isMovingEnd 메소드는")
	class Describe_isMovingEnd {
		private List<String> InputBridge = new ArrayList<>(Arrays.asList("U", "D", "U"));

		@Nested
		@DisplayName("만약 다리의 모든칸의 검사가 완료되면")
		class Context_all_bridge_part_inspect_complete {
			List<String> userMoving = new ArrayList<>(Arrays.asList("U", "D", "U"));

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				Bridge bridge = new Bridge(InputBridge);
				userMoving.stream()
					.forEach(direction -> {
						bridge.checkUserMoving(direction);
					});

				assertThat(bridge.isMovingEnd()).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 다리의 모든칸의 검사가 완료되지 않으면")
		class Context_all_bridge_part_inspect_not_complete {
			List<String> userMoving = new ArrayList<>(Arrays.asList("U", "U"));

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				Bridge bridge = new Bridge(InputBridge);
				userMoving.stream()
					.forEach(direction -> {
						bridge.checkUserMoving(direction);
					});

				assertThat(bridge.isMovingEnd()).isFalse();
			}
		}
	}
}
