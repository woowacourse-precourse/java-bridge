package bridge.domain;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import bridge.util.GameConst;

class UserBridgeTest {

	private static Stream<Arguments> getUserBridgeStatusProvideForResult() {
		return Stream.of(
			Arguments.of(GameConst.MOVING_UP, UserBridge.UPPER_BRIDGE),
			Arguments.of(GameConst.MOVING_DOWN, UserBridge.LOWER_BRIDGE)
		);
	}

	private static Stream<Arguments> getOtherUserBridgeStatusProvideForResult() {
		return Stream.of(
			Arguments.of(GameConst.MOVING_UP, UserBridge.LOWER_BRIDGE),
			Arguments.of(GameConst.MOVING_DOWN, UserBridge.UPPER_BRIDGE)
		);
	}

	@ParameterizedTest(name = "주어진 location 의 userBridge 확인 테스트")
	@MethodSource("getUserBridgeStatusProvideForResult")
	void getUserBridgeStatus(String location, UserBridge userBridge) {

		UserBridge userBridgeStatusTest = UserBridge.getUserBridgeStatus(location);

		Assertions.assertThat(userBridge).isEqualTo(userBridgeStatusTest);
	}

	@ParameterizedTest(name = "주어진 location 반대 userBridge 확인 테스트")
	@MethodSource("getOtherUserBridgeStatusProvideForResult")
	void getOtherUserBridgeStatus(String location, UserBridge userBridge) {
		UserBridge userBridgeStatusTest = UserBridge.getOtherUserBridgeStatus(location);

		Assertions.assertThat(userBridge).isEqualTo(userBridgeStatusTest);
	}
}
