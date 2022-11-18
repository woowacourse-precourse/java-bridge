package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.dto.MovingResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Bridge 클래스")
class BridgeTest {

	@Nested
	@DisplayName("judgeUserMoving 메소드는")
	class Describe_judgeUserMoving {
		private final int BRIDGE_SIZE = 3;
		private final int CURRENT_LOCATION = 1;
		private final boolean MOVING_RESULT_SUCCESS = true;
		private final boolean MOVING_RESULT_FAIL = false;
		private List<String> InputBridge = new ArrayList<>(Arrays.asList("U", "D", "U"));
		private Bridge bridge = new Bridge(InputBridge, BRIDGE_SIZE);

		@Nested
		@DisplayName("만약 이동할 칸과 다리의 해당 칸이 일치하지 않는다면")
		class Context_user_moving_and_bridge_are_not_correct {
			private String userMoving = "U";

			@Test
			@DisplayName("이동에 실패한다.")
			void it_returns_MovingResult() {
				MovingResult movingResult = bridge.judgeUserMoving(CURRENT_LOCATION, userMoving);
				MovingResult expected = new MovingResult(userMoving, MOVING_RESULT_FAIL);
				assertThat(movingResult).usingRecursiveComparison().isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("만약 이동할 칸과 다리의 해당 칸이 일치한다면")
		class Context_user_moving_and_bridge_are_correct {
			private String userMoving = "D";

			@Test
			@DisplayName("이동에 성공한다.")
			void it_returns_MovingResult() {
				MovingResult movingResult = bridge.judgeUserMoving(CURRENT_LOCATION, userMoving);
				MovingResult expected = new MovingResult(userMoving, MOVING_RESULT_SUCCESS);
				assertThat(movingResult).usingRecursiveComparison().isEqualTo(expected);
			}
		}
	}
}
