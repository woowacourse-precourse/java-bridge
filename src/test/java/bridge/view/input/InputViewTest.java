package bridge.view.input;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class InputViewTest extends NsTest {

	@DisplayName("input 값에 대한 최초 검증으로서 값이 없는 경우 예외 처리를 검증한다")
	@Test
	void verify_EmptyInputHandling() {
		assertSimpleTest(() -> {
			run(" ");
			assertThat(output()).contains(InputException.EMPTY);
		});
	}

	@Override
	protected void runMain() {
		try {
			new InputView();
		} catch (Exception ignored) {
		}
	}
}
