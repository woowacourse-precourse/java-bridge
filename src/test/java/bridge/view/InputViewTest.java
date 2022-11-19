package bridge.view;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class InputViewTest extends NsTest {
	@DisplayName("다리길이 입력 테스트") @Test void inputViewTest1() {
		InputView inputView = new InputView();

		assertSimpleTest(() -> {
			runException("3");
		});
		String bridgeSize = inputView.readBridgeSize();

		Assertions.assertThat(bridgeSize).hasSizeBetween(1,2);
		Assertions.assertThat(bridgeSize).isInstanceOf(String.class);
	}

	@DisplayName("이동 입력(U) 테스트") @Test void inputViewTest2() {
		InputView inputView = new InputView();

		assertSimpleTest(() -> {
			runException("U");
		});
		String moving = inputView.readMoving();

		Assertions.assertThat(moving).isInstanceOf(String.class);
		Assertions.assertThat(moving).isEqualTo("U");
	}

	@DisplayName("이동 입력(D) 테스트") @Test void inputViewTest3() {
		InputView inputView = new InputView();

		assertSimpleTest(() -> {
			runException("D");
		});
		String moving = inputView.readMoving();

		Assertions.assertThat(moving).isInstanceOf(String.class);
		Assertions.assertThat(moving).isEqualTo("D");
	}

	@DisplayName("게임 재시작(R) 테스트") @Test void inputViewTest4() {
		InputView inputView = new InputView();

		assertSimpleTest(() -> {
			runException("R");
		});
		String moving = inputView.readGameCommand();

		Assertions.assertThat(moving).isInstanceOf(String.class);
		Assertions.assertThat(moving).isEqualTo("R");
	}

	@DisplayName("게임 종료(Q) 테스트") @Test void inputViewTest5() {
		InputView inputView = new InputView();

		assertSimpleTest(() -> {
			runException("Q");
		});
		String moving = inputView.readGameCommand();

		Assertions.assertThat(moving).isInstanceOf(String.class);
		Assertions.assertThat(moving).isEqualTo("Q");
	}

	@Override protected void runMain() {
		Application.main(new String[]{});
	}
}
