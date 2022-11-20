package bridge.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameServiceTest {
	BridgeGameService bridgeGameService = new BridgeGameService();

	@ParameterizedTest
	@ValueSource(ints = {2, 1, 30, 23, 100, 1000})
	@DisplayName("다리 길이 입력값 예외 처리 테스트")
	void bridgeSizeInputFailTest(int input) {
		assertThrows(IllegalArgumentException.class, () -> bridgeGameService.checkBridgeSize(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"R", "S", "T", "L", "O", "Q"})
	@DisplayName("다리 이동 입력값 예외 처리 테스트")
	void moveInputFailTest(String input) {
		assertThrows(IllegalArgumentException.class, () -> bridgeGameService.checkMoveCommand(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"P", "V", "U", "B", "N", "D", "M"})
	@DisplayName("재시작 입력값 예외 처리 테스트")
	void restartInputFailTest(String input) {
		assertThrows(IllegalArgumentException.class, () -> bridgeGameService.retryOrEnd(input));
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 3, 10, 20, 15})
	@DisplayName("다리 길이 입력값 통과 테스트")
	void bridgeSizeInputTest(int input) {
		assertDoesNotThrow(() -> bridgeGameService.checkBridgeSize(input));
	}

	@ParameterizedTest
	@CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
	@DisplayName("다리 이동 입력값 통과 테스트")
	void moveInputTest(String input, String result) {
		assertEquals(result, bridgeGameService.checkMoveCommand(input));
	}

	@ParameterizedTest
	@CsvSource(value = {"R:true", "Q:false"}, delimiter = ':')
	@DisplayName("재시작 입력값 통과 테스트")
	void restartInputTest(String input, boolean result) {
		assertEquals(result, bridgeGameService.retryOrEnd(input));
	}

}
