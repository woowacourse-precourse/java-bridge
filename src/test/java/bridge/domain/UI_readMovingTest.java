package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UI_readMovingTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";
	InputView inputView = new InputView();

	@DisplayName("다리를 선택할 때 U나 D의 문자가 아니면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = { "F", "q", "R" })
	public void bridgeShouldBeChoosenUOrD(String UorD) {
		assertSimpleTest(() -> {
			runException(UorD);
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
		inputView.readMoving();
	}

}
