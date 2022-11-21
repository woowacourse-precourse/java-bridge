package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UI_readGameCommandTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";
	InputView inputView = new InputView();

	@DisplayName("다리 건너기 게임을 재시작할지 종료할지 여부에서 R이나 Q의 문자가 아니면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = { "a", "U" })
	public void restartShouldBeChoosenROrU(String RorQ) {
		assertSimpleTest(() -> {
			runException(RorQ);
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
		inputView.readGameCommand();
	}

}
