package bridge.domain.player;

import bridge.view.input.InputCommandReader;
import bridge.view.input.InputException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class BridgeSizeCommandTest extends NsTest {

	private static final int FIRST_NUMBER_INCLUSIVE = 3;
	private static final int LAST_NUMBER_INCLUSIVE = 20;

	@DisplayName("다리 길이의 정상값을 입력했을 때 인스턴스 생성을 검증한다")
	@ParameterizedTest
	@ValueSource(ints = {3, 7, 13, 20})
	void verify_BridgeSize_CreateInstance(int value) {
		assertThat(new BridgeSizeCommand(value)).isInstanceOf(BridgeSizeCommand.class);
	}

	@DisplayName("다리 길이의 입력시 자연수가 아닌 값에 대한 예외 처리를 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {"a", "3.", "10.5"})
	void verify_BridgeSize_NumberOnly(String value) {
		assertThatThrownBy(() -> BridgeSizeCommand.valueOf(value))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(InputException.NOT_A_NUMBER);
	}

	@DisplayName("다리 길이의 입력시 3 이상 20 이하의 숫자 범위 조건 불만족에 대한 예외 처리를 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {"2", "21", "-3"})
	void verify_BridgeSize_RangeIsAsAssigned(String value) {
		assertThatThrownBy(() -> BridgeSizeCommand.valueOf(value))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(String.format(InputException.NOT_IN_BETWEEN_PROPER_RANGE, FIRST_NUMBER_INCLUSIVE, LAST_NUMBER_INCLUSIVE));
	}

	@DisplayName("input 값에 대한 검증으로서 예외 발생시 재 입력 요청 기능을 검증한다")
	@Test
	void verify_rePrompt() {
		assertSimpleTest(() -> {
			run("a", " ", "0");
			assertThat(output()).contains(
					InputException.EMPTY,
					InputException.NOT_A_NUMBER,
					String.format(InputException.NOT_IN_BETWEEN_PROPER_RANGE, FIRST_NUMBER_INCLUSIVE, LAST_NUMBER_INCLUSIVE)
			);
		});
	}

	@Override
	protected void runMain() {
		try {
			InputCommandReader.read("BridgeSize");
		} catch (Exception ignored) {
		}
	}
}
