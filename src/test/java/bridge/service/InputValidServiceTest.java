package bridge.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.util.ErrorConst;

class InputValidServiceTest {

	private InputValidService inputValidService;

	@BeforeEach
	void setUp() {
		inputValidService = new InputValidService();
	}

	@DisplayName("bridgeSize 의 예외값으로 실패 테스트 - 정수 및 숫자가 아닌 경우, bridgeSize 가 3~20 이 아닌 경우")
	@ValueSource(strings = {"@!", " ", "2", "21", "3.4"})
	@ParameterizedTest
	void validBridgeSizeErrorTest(String bridgeSize) {
		Assertions.assertThatThrownBy(() -> inputValidService.validBridgeSize(bridgeSize))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorConst.ERROR_PREFIX);
	}

	@DisplayName("bridgeSize 의 정상 값 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3, 3", "20, 20", "5, 5"})
	void validBridgeSizeTest(String bridgeSize, Integer bridgeSizeNumber) {
		Assertions.assertThat(inputValidService.validBridgeSize(bridgeSize)).isEqualTo(bridgeSizeNumber);
	}

	@DisplayName("인자로 들어온 userMoving 값이 U 또는 D 이 아닌 경우")
	@ValueSource(strings = {"@!", " ", "2", "21", "A", "u", "r", ""})
	@ParameterizedTest
	void validUserMovingErrorTest(String userMoving) {
		Assertions.assertThatThrownBy(() -> inputValidService.validUserMoving(userMoving))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorConst.ERROR_PREFIX);
	}

	@DisplayName("userMoving 의 정상 값 테스트")
	@ParameterizedTest
	@CsvSource(value = {"U, U", "D, D"})
	void validUserMovingTest(String userMoving, String userMovingTest) {
		Assertions.assertThat(inputValidService.validUserMoving(userMoving))
			.isEqualTo(userMovingTest);
	}

	@DisplayName("인자로 들어온 userCommand 값이 R 또는 Q 이 아닌 경우")
	@ValueSource(strings = {"@!", " ", "2", "21", "A", "r", "q", ""})
	@ParameterizedTest
	void validUserCommandErrorTest(String userCommand) {
		Assertions.assertThatThrownBy(() -> inputValidService.validUserCommand(userCommand))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorConst.ERROR_PREFIX);
	}

	@DisplayName("userCommand 의 정상 값 테스트")
	@ParameterizedTest
	@CsvSource(value = {"R, R", "Q, Q"})
	void validUserCommandTest(String userCommand, String userCommandTest) {
		Assertions.assertThat(inputValidService.validUserCommand(userCommand))
			.isEqualTo(userCommandTest);
	}
}
