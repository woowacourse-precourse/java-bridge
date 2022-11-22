package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeGame 클래스")
class BridgeGameTest {

	@Nested
	@DisplayName("move 메소드는")
	class Describe_move {
		private List<String> inputBridge = new ArrayList<>(Arrays.asList("U", "D", "D", "U"));

		@Nested
		@DisplayName("만약 이동결과가 성공이면")
		class Context_moving_result_success {
			private List<String> movings = new ArrayList<>(Arrays.asList("U", "D", "D", "U"));
			private Bridge bridge = new Bridge(inputBridge);
			private BridgeGame bridgeGame = new BridgeGame(bridge);

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				movings.stream()
					.forEach(moving -> {
						InputStream in = new ByteArrayInputStream(moving.getBytes());
						System.setIn(in);
						boolean movingResult = bridgeGame.move();
						assertThat(movingResult).isTrue();
					});
			}
		}

		@Nested
		@DisplayName("만약 이동결과가 실패면")
		class Context_moving_result_fail {
			private List<String> movings = new ArrayList<>(Arrays.asList("D", "U", "U", "D"));
			private Bridge bridge = new Bridge(inputBridge);
			private BridgeGame bridgeGame = new BridgeGame(bridge);

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				movings.stream()
					.forEach(moving -> {
						InputStream in = new ByteArrayInputStream(moving.getBytes());
						System.setIn(in);
						boolean movingResult = bridgeGame.move();
						assertThat(movingResult).isFalse();
					});
			}
		}
	}

	@Nested
	@DisplayName("retry 메소드는")
	class Describe_retry {
		private List<String> inputBridge = new ArrayList<>(Arrays.asList("U", "D", "D", "U"));
		private Bridge bridge = new Bridge(inputBridge);
		private BridgeGame bridgeGame = new BridgeGame(bridge);

		@Nested
		@DisplayName("만약 입력한 재시도 명령어가 R이면")
		class Context_retry_command_is_R {

			private String inputCommand = "R";

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				InputStream in = new ByteArrayInputStream(inputCommand.getBytes());
				System.setIn(in);
				boolean isRetry = bridgeGame.retry();
				assertThat(isRetry).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 입력한 재시도 명령어가 Q면")
		class Context_retry_command_is_Q {
			private String inputCommand = "Q";

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				InputStream in = new ByteArrayInputStream(inputCommand.getBytes());
				System.setIn(in);
				boolean isRetry = bridgeGame.retry();
				assertThat(isRetry).isFalse();
			}
		}
	}

	@Nested
	@DisplayName("keepMove 메소드는")
	class Describe_keepMove {
		private List<String> inputBridge = new ArrayList<>(Arrays.asList("U", "D", "D", "U"));

		@Nested
		@DisplayName("만약 모든 다리칸의 방향을 확인했다면")
		class Context_check_all_bridge_direction {
			private List<String> movings = new ArrayList<>(Arrays.asList("U", "D", "D", "U"));

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				Bridge bridge = new Bridge(inputBridge);
				BridgeGame bridgeGame = new BridgeGame(bridge);
				movings.stream()
					.forEach(moving -> {
						InputStream in = new ByteArrayInputStream(moving.getBytes());
						System.setIn(in);
						bridgeGame.move();
					});
				assertThat(bridgeGame.keepMove()).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 모든 다리칸의 방향을 확인하지 못했다면")
		class Context_not_check_all_bridge_direction {
			private List<String> movings = new ArrayList<>(Arrays.asList("U", "D", "D"));

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_false() {
				Bridge bridge = new Bridge(inputBridge);
				BridgeGame bridgeGame = new BridgeGame(bridge);
				movings.stream()
					.forEach(moving -> {
						InputStream in = new ByteArrayInputStream(moving.getBytes());
						System.setIn(in);
						bridgeGame.move();
					});
				assertThat(bridgeGame.keepMove()).isFalse();
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
			assertThat(bridgeGame.getBridgeMap()).usingRecursiveComparison().isEqualTo(expected);
		}
	}
}
