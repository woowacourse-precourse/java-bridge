package bridge.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {

	private final String error_message= "[ERROR]";

	private InputValidation iv;

	@BeforeAll
	static void initailize(){
		iv=new InputValidationTest();
	}

	@ParameterizedTest
	@ValueSource(strings = {"1","-23","한글입니다","It's English","21000000000","21"})
	@DisplayName("유저의_다리길이_입력값_유효성검사")
	void user_input_bridge_length_validation(String source){
		assertThatThrownBy(()->iv.user_input_bridge_length_validation(source))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(error_message);
	}
}
