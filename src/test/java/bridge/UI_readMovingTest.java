package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.domain.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;

public class UI_readMovingTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";
	private InputView inputView = new InputView();

	@DisplayName("다리를 선택할 때 U나 D의 문자가 아니면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = { "F", "q", "R" })
	public void bridgeShouldBeChoosenUOrD(String UorD) {
		assertThatThrownBy(() -> inputView.readMovingExceptionCheck(UorD))
    		.isInstanceOf(IllegalArgumentException.class)
    		.hasMessageContaining(ERROR_MESSAGE);
	}

	@Override
	protected void runMain() {
		 Application.main(new String[]{});
	}

}
