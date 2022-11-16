package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

public class ViewTest {

	@DisplayName("숫자 입력 정상 케이스 테스트")
	@ValueSource(strings = {"1", "2","10", "1 2"})
	@Test
	void InputNumValidatorTest(String input) {
		Assertions.assertThatCode(() -> new InputNumValidator(input))
				.doesNotThrowAnyException();
	}

	@DisplayName("숫자 입력 예외 케이스 테스트")
	@ValueSource(strings = {" ", "", "what"})
	@Test
	void InputNumValidatorTest(String input) {
		Assertions.assertThatThrownBy(() -> new InputNumValidator(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자 입력 정상 케이스 테스트")
	@ValueSource(strings = {"D", "U", "R", "Q"})
	@Test
	void InputStringValidatorTest(String input) {
		Assertions.assertThatCode(() -> new InputStringValidator(input))
				.doesNotThrowAnyException();
	}

	@DisplayName("문자 예외 케이스 테스트")
	@ValueSource(strings = {" ", "", "1", "$", "a,b"})
	@Test
	void InputStringValidatorTest(String input) {
		Assertions.assertThatThrownBy(() -> new InputStringValidator(input))
				.isInstanceOf(IllegalArgumentException.class);
	}



//	@DisplayName("다리 생성 정상 테스트")
//	@ValueSource(ints = {3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
//	@Test
//	void BridgeSizeTest(Integer input) {
//		Assertions.assertThatCode(() -> {
//			BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
//			bridgeMaker.makeBridge(input);
//		}).doesNotThrowAnyException();
//	}
//
//	@DisplayName("다리 생성 예외 테스트")
//	@ValueSource(ints = {-1, 0, 1, 2, 21, 50, 100})
//	@Test
//	void BridgeSizeExceptionTest(Integer input) {
//		Assertions.assertThatThrownBy(() -> {
//			BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
//			bridgeMaker.makeBridge(input);
//		}).isInstanceOf(IllegalArgumentException.class);
//	}
}
