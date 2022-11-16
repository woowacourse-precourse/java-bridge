package bridge.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputViewTest {

	@Test
	void 사이즈_입력_테스트(){
		InputView input = new InputView();
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> input.readBridgeSize());
	}

	@Test
	void 이동_테스트(){
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validator.isMoveValidate("a"));
	}

	
}
