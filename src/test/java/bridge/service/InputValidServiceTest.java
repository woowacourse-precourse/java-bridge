package bridge.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidServiceTest {

	private InputValidService inputValidService;

	@BeforeEach
	void setUp() {
		inputValidService = new InputValidService();
	}

	@DisplayName("bridgeSize 의 예외값으로 실패 테스트 - 숫자가 아닌 경우, bridgeSize 가 3~20 이 아닌 경우")
	@ValueSource(strings = {"@!", " ", "2", "21"})
	@ParameterizedTest
	void validBridgeSizeErrorTest(String bridgeSize) {
		Assertions.assertThatThrownBy(() -> inputValidService.validBridgeSize(bridgeSize))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("bridgeSize 의 정상 값 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3, 3", "20, 20", "5, 5"})
	void validBridgeSizeTest(String bridgeSize, Integer bridgeSizeNumber) {
		System.out.println(bridgeSize);
		System.out.println(bridgeSizeNumber);
		Assertions.assertThat(inputValidService.validBridgeSize(bridgeSize)).isEqualTo(bridgeSizeNumber);
	}

	@Test
	void validUserMoving() {
		//given

		//when

		//then
	}

	@Test
	void validUserCommand() {
		//given

		//when

		//then
	}
}
