package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
				BridgeGame bridgeGame = new BridgeGame();

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
				BridgeGame bridgeGame = new BridgeGame();

				movings.stream()
					.forEach(moving -> {
						User user = new User(moving);
						boolean moveResult = bridgeGame.move(user, bridge, bridgeMap);
						assertThat(moveResult).isFalse();
					});
			}
		}
	}
}
