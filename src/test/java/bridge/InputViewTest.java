package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

	@DisplayName("input 값에 대한 최초 검증으로서 값이 없는 경우 예외 처리를 검증한다")
	@Test
	void verify_EmptyInputHandling() {
		InputView inputView = new InputView();

		assertThatThrownBy(() -> inputView.validate(""))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(InputException.EMPTY);
	}
}
