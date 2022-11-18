package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.dto.MovingResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeMap 클래스")
class BridgeMapTest {

	@Nested
	@DisplayName("isMovingSuccess 메소드는")
	class Describe_isMovingSuccess {
		private BridgeMap bridgeMap = new BridgeMap();
		private int currentLocation = 0;

		@Nested
		@DisplayName("해당 칸의 이동 결과가 성공이라면")
		class Context_bridge_map_current_location_answer_is_success {
			private MovingResult movingResult = new MovingResult("U", true);

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				bridgeMap.addResult(movingResult);
				boolean isMovingSuccess = bridgeMap.isMovingSuccess(currentLocation);

				assertThat(isMovingSuccess).isTrue();
			}
		}

		@DisplayName("해당 칸의 이동 결과가 실패라면")
		@Nested
		class Context_bridge_map_current_location_answer_is_fail {
			private MovingResult movingResult = new MovingResult("D", false);

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_false() {
				bridgeMap.addResult(movingResult);
				boolean isMovingSuccess = bridgeMap.isMovingSuccess(currentLocation);

				assertThat(isMovingSuccess).isFalse();
			}
		}
	}
}
