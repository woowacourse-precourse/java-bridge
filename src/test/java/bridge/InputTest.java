package bridge;

import static bridge.common.exception.ErrorMessage.*;
import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class InputTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR] ";

	@Test
	void 다리_길이_예외_테스트_문자_입력() {
		assertSimpleTest(() -> {
			runException("a");
			assertThat(output()).contains(ERROR_MESSAGE + NON_NUMERIC_EXCEPTION_MESSAGE);
		});
	}

	@Test
	void 다리_길이_예외_테스트_범위_이하() {
		assertSimpleTest(() -> {
			runException("0");
			assertThat(output()).contains(ERROR_MESSAGE + INVALID_BRIDGE_LENGTH_EXCEPTION_MESSAGE);
		});
	}

	@Test
	void 방향_입력_예외_테스트_잘못된_문자_입력() {
		assertSimpleTest(() -> {
			runException("3", "a");
			assertThat(output()).contains(ERROR_MESSAGE + NOT_UP_OR_DOWN_EXCEPTION_MESSAGE);
		});
	}

	@Test
	void 재시도_테스트_잘못된_문자_입력() {
		assertRandomNumberInRangeTest(() -> {
			runException("3", "D", "W");
			assertThat(output()).contains(ERROR_MESSAGE + NOT_RESTART_OR_QUIT_EXCEPTION_MESSAGE);

		}, 1, 0, 1);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
