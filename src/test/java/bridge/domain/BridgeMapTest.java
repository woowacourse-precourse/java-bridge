package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeMap 클래스")
class BridgeMapTest {

	@Nested
	@DisplayName("move 메소드는")
	class Describe_move {
		private final List<String> INPUT_BRIDGE = new ArrayList<>(Arrays.asList("U", "D", "U"));
		private final int BRIDGE_SIZE = 3;
		private final Bridge bridge = new Bridge(INPUT_BRIDGE, BRIDGE_SIZE);
		private BridgeMap bridgeMap = new BridgeMap();


		@Nested
		@DisplayName("만약 이동한 결과가 성공 이라면")
		class Context_moving_result_success {

			@Test
			@DisplayName("true를 반환한다.")
			void it_returns_true() {
				String moving = "U";
				int currentSize = 0;
				User user = new User(moving);
				boolean result = bridgeMap.move(user, bridge, currentSize);
				assertThat(result).isTrue();
			}
		}

		@Nested
		@DisplayName("만약 이동한 결과가 실패 라면")
		class Context_moving_result_fail {

			@Test
			@DisplayName("false를 반환한다.")
			void it_returns_true() {
				String moving = "U";
				int currentSize = 1;
				User user = new User(moving);
				boolean result = bridgeMap.move(user, bridge, currentSize);
				assertThat(result).isFalse();
			}
		}
	}

	@Nested
	@DisplayName("getSplitMap 메소드는")
	class Describe_getSplitMap {
		private List<String> inputBridge = new ArrayList<>(Arrays.asList("D", "D", "U"));
		private int size = 3;
		private Bridge bridge = new Bridge(inputBridge, size);

		@Nested
		@DisplayName("만약 다리에서 이동한 적이 있다면")
		class Context_has_moving_from_bridge {
			private final String UP_MOVING = "U";
			private final String DOWN_MOVING = "D";
			private int currentLocation = 0;
			private BridgeMap bridgeMap = new BridgeMap();

			@Test
			@DisplayName("다리 이동 결과를 다리 윗칸과 다리 아랫칸으로 나누어 반환한다.")
			void it_returns_converted_moving_results() {
				User firstUser = new User(UP_MOVING);
				User secondUser = new User(DOWN_MOVING);
				bridgeMap.move(firstUser, bridge, currentLocation++);
				bridgeMap.move(secondUser, bridge, currentLocation);
				List<String> splitBridgeMap = bridgeMap.getSplitMap();
				List<String> expected = new ArrayList<>(Arrays.asList("[ X |   ]", "[   | O ]"));

				assertThat(splitBridgeMap).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("만약 다리에서 이동한 적이 없다면")
		class Context_has_not_moving_from_bridge {
			private BridgeMap bridgeMap = new BridgeMap();

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> bridgeMap.getSplitMap())
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}
