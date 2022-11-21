package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

	@DisplayName("다리 길이 입력 유효성 검사")
	@Test
	void TestBridgeSizeValidation() {
		InputView inputView = new InputView();
		assertThatThrownBy(() -> inputView.validateBridgeSize(""))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> inputView.validateBridgeSize("1"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> inputView.validateBridgeSize("a"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("이동 입력 유효성 검사")
	@Test
	void TestMoveValidation() {
		InputView inputView = new InputView();
		assertThatThrownBy(() -> inputView.validateMove("u"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> inputView.validateMove("d"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> inputView.validateMove("a"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("게임 재시도 입력 유효성 검사")
	@Test
	void TestRetryValidation() {
		InputView inputView = new InputView();
		assertThatThrownBy(() -> inputView.validateRetry("r"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> inputView.validateRetry("q"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> inputView.validateRetry("a"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
