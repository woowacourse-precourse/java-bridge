package bridge.domain.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameTest {

	@DisplayName("이동 테스트")
	@ParameterizedTest
	@MethodSource("generateData")
	void 다리이동_테스트(List<String> mockBridges, String moveCommand, boolean expected) {
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.setBridges(mockBridges);
		bridgeGame.move(moveCommand);
		Assertions.assertThat(bridgeGame.isSuccessStage()).isEqualTo(expected);
	}

	static Stream<Arguments> generateData() {
		return Stream.of(
				Arguments.of(Arrays.asList("U", "D", "U"), "U", true),
				Arguments.of(Arrays.asList("U", "D", "U"), "D", false)
		);
	}

	@DisplayName("재시작 기능 테스트")
	@ParameterizedTest
	@CsvSource(value = {"R:2:true"}, delimiterString = ":")
	void 재시작_기능_테스트(String command, int countExcpected, boolean isSuccessStageExpected) {
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.retry(command);
		Assertions.assertThat(bridgeGame.getCountOfAttemps()).isEqualTo(countExcpected);
		Assertions.assertThat(bridgeGame.isSuccessStage()).isEqualTo(isSuccessStageExpected);
	}
}