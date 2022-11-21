package bridge.domain.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class BridgeChannelTest {

	@DisplayName("Bridge 생성시 필요한 shape(알파벳)을 소유한 enum 클래스의 기능을 검증한다")
	@ParameterizedTest(name = "{index} => channelType={0}, channelShape={1}")
	@MethodSource("bridgeChannel")
	void verify_BridgeChannel_CanReturnAssignedElementCorrectly(int channelType, String channelShape) {
		String actual = BridgeChannel.of(channelType).Shape();
		String expected = channelShape;

		assertThat(actual).isEqualTo(expected);
	}

	private static Stream<Arguments> bridgeChannel() {
		return Stream.of(
				arguments(0, "D"),
				arguments(1, "U")
		);
	}
}
