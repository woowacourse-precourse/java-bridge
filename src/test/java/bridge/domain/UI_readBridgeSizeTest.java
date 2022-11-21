package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UI_readBridgeSizeTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";
	InputView inputView = new InputView();

	@DisplayName("다리의 길이가 3이상 20이하의 정수가 아닐 경우 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = { "2", "23" })
	public void bridgeSizeShouldBeFromThreeToTwentyNumber(String input) {
		assertSimpleTest(() -> {
			runException(input);
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
		inputView.readBridgeSize();
	}

}
