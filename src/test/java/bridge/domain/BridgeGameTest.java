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
	private BridgeGame bridgeGame = new BridgeGame();

	@Nested
	@DisplayName("move 메소드는")
	class Describe_move {

		@Nested
		@DisplayName("만약 이동결과가 성공이면")
		class Context_moving_result_success {
			List<String> movings = new ArrayList<>(Arrays.asList("U", "D", "D", "U"));
			List<String> inputBridge = new ArrayList<>(Arrays.asList("U", "D", "D", "U"));

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				Bridge bridge = new Bridge(inputBridge);
				BridgeMap bridgeMap = new BridgeMap();

				movings.stream()
					.forEach(moving -> {
						User user = new User(moving);
						boolean moveResult = bridgeGame.move(user, bridge, bridgeMap);
						assertThat(moveResult).isTrue();
					});
			}
		}

		@Nested
		@DisplayName("만약 이동결과가 실패면")
		class Context_moving_result_fail {
			List<String> movings = new ArrayList<>(Arrays.asList("D", "U", "U", "D"));
			List<String> inputBridge = new ArrayList<>(Arrays.asList("U", "D", "D", "U"));

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				Bridge bridge = new Bridge(inputBridge);
				BridgeMap bridgeMap = new BridgeMap();

				movings.stream()
					.forEach(moving -> {
						User user = new User(moving);
						boolean moveResult = bridgeGame.move(user, bridge, bridgeMap);
						assertThat(moveResult).isFalse();
					});
			}
		}
	}

	@Nested
	@DisplayName("retry 메소드는")
	class Describe_retry {

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
}
