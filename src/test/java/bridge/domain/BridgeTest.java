package bridge.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

	private Bridge bridge = new Bridge();

	@DisplayName("checkValidSpace 테스트 - 유저가 건널수 있는 다리인지 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"U, 0, true", "D, 1, true", "U, 2, true", "D, 3, false"})
	void checkValidSpace(String userSpace, Integer currentSpace, boolean isValid) {
		//given
		List<String> bridgeTest = List.of("U", "D", "U", "U");

		//when
		bridge.initBridge(bridgeTest);
		boolean isValidTest = bridge.checkValidSpace(userSpace, currentSpace);

		//then
		Assertions.assertThat(isValid).isEqualTo(isValidTest);
	}
}
