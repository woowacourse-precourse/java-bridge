package bridge.filter;

import static bridge.restrict.RestrictConstants.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputFilterTest {

	private final UserInputFilter filter = new UserInputFilter();

	@Test
	@DisplayName("min, max 사이의 값 변환")
	void bindingBridgeSizeTest() {
		int minBridgeSize = filter.bindingBridgeSize("3");
		int maxBridgeSize = filter.bindingBridgeSize("20");
		Assertions.assertThat(minBridgeSize).isEqualTo(MIN_NUMBER);
		Assertions.assertThat(maxBridgeSize).isEqualTo(MAX_NUMBER);
	}

	@ParameterizedTest
	@DisplayName("min, max 사이의 값이 아닌 경우 예외 발생")
	@ValueSource(strings = {"", "2", "21", "10a", "aa"})
	void bindingBridgeSizeExceptionTest(String userInput) {
		Assertions.assertThatThrownBy(() -> filter.bindingBridgeSize(userInput))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
