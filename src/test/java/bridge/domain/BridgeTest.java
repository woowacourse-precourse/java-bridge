package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Bridge 클래스")
public class BridgeTest {

	@DisplayName("다리 길이가 3 보다 작거나 20 보다 크면 예외가 발생한다.")
	@ParameterizedTest(name = "다리길이 : {0} , 예외 발생 예상 : {1}")
	@CsvSource({"2, true", "3, false", "20, false", "21, true"})
	void bridge_length_exception_text(int length, boolean hasException) {
		if (hasException) {
			assertThatThrownBy(() -> new Bridge(length))
				.isInstanceOf(IllegalArgumentException.class);
		}

		if (!hasException) {
			Bridge bridge = new Bridge(length);
			assertThat(bridge).isNotNull();
		}
	}
}
