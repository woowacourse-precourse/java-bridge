package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
		@DisplayName("만약 다리의 길이가 3에서 20사이가 아니라면")
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
			@DisplayName("false를 포함한 이동결과 객체를 bridgeMap에 저장한다.")
			void it_returns_moving_result_include_false() {
				Bridge bridge = new Bridge(InputBridge);
				userMoving.stream()
					.forEach(direction -> {
						bridge.checkUserMoving(direction);
						BridgeMap bridgeMap = bridge.getBridgeMap();
						assertThat(bridgeMap.getMovingResult()).isFalse();
					});
			}
		}

		@Nested
		@DisplayName("만약 이동할 방향과 해당 다리 칸의 방향이 일치하면")
		class Context_user_moving_and_bridge_are_correct {
			List<String> userMoving = new ArrayList<>(Arrays.asList("U", "D", "U"));

			@Test
			@DisplayName("true를 포함한 이동결과 객체를 반환한다.")
			void it_returns_moving_result_include_true() {
				Bridge bridge = new Bridge(InputBridge);
				userMoving.stream()
					.forEach(direction -> {
						bridge.checkUserMoving(direction);
						BridgeMap bridgeMap = bridge.getBridgeMap();
						assertThat(bridgeMap.getMovingResult()).isTrue();
					});
			}
		}
	}

	@Nested
	@DisplayName("getBridgeMap 메소드는")
	class Describe_getBridgeMap {
		private List<String> inputBridge = new ArrayList<>(Arrays.asList("U", "D", "D", "U"));
		private List<String> movings = new ArrayList<>(Arrays.asList("U", "U", "D", "U"));

		private List expectedMovingResults = List.of(
			new MovingResult("U", true),
			new MovingResult("U", false),
			new MovingResult("D", true),
			new MovingResult("U", true)
		);

		@Test
		@DisplayName("이동결과들을 반환한다.")
		void it_returns_moving_results() {
			Bridge bridge = new Bridge(inputBridge);
			BridgeGame bridgeGame = new BridgeGame(bridge);
			movings.stream()
				.forEach(moving -> {
					InputStream in = new ByteArrayInputStream(moving.getBytes());
					System.setIn(in);
					bridgeGame.move();
				});

			BridgeMap expected = new BridgeMap();
			expectedMovingResults.stream()
				.forEach(movingResult -> {
					expected.addMovingResult((MovingResult) movingResult);
				});
			assertThat(bridge.getBridgeMap()).usingRecursiveComparison().isEqualTo(expected);
		}
	}


	@Nested
	@DisplayName("isCrossBridge 메소드는")
	class Describe_isCrossBridge {
		private List<String> InputBridge = new ArrayList<>(Arrays.asList("U", "D", "U"));

		@Nested
		@DisplayName("만약 다리의 모든 칸을 건너면")
		class Context_cross_bridge {
			List<String> userMoving = new ArrayList<>(Arrays.asList("U", "D", "U"));

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				Bridge bridge = new Bridge(InputBridge);
				userMoving.stream()
					.forEach(direction -> {
						bridge.checkUserMoving(direction);
					});

				assertThat(bridge.isCrossBridge()).isTrue();
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
				userMoving.stream()
					.forEach(direction -> {
						bridge.checkUserMoving(direction);
					});

				assertThat(bridge.isCrossBridge()).isFalse();
			}
		}
	}
}
