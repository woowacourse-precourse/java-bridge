package bridge.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputViewTest {

	@Test
	void 사이즈_입력_테스트() {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> InputView.readBridgeSize());
	}

	@Test
	void 이동_테스트() {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validator.isMoveValidate("a"));
		// Assertions.assertThrows( ,
		// 	() -> Validator.isMoveValidate("U"));
	}

	@Test
	void 재시작_종료_입력_테스트() {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validator.isCommandValidate("a"));
	}
	// Assertions.assertThrows( ,
	// 	() -> Validator.isMoveValidate("U"));
}
