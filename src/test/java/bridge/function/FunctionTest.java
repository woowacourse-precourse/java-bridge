package bridge.function;

import bridge.InputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.InputValidation;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionTest {

	private final String error_message= "[ERROR]";

	private static InputValidation iv;

	private static InputView inputView;

	@BeforeAll
	static void initailize(){
		iv=new InputValidation();
		inputView=new InputView();
	}

	@Test
	@DisplayName("옳바른 길이 값이 입력됐을 경우")
	void user_input_bridge_length_correct(){
		//given
		String bridge_size = iv.userInputBridgeSizeValidation("17");
		//when
		int compare_size = Integer.parseInt(bridge_size);
		//then
		assertThat(compare_size).isEqualTo(17);
	}

	@Test
	@DisplayName("옳바르지 못한 길이 값이 입력됐을 경우")
	void user_input_bridge_length_non_correct(){
		//given
		try {
			String bridge_size = iv.userInputBridgeSizeValidation("24");
			//when
			int compare_size = Integer.parseInt(bridge_size);
		}catch (NumberFormatException n){
			//then
			assertThat(n.getMessage()).contains(error_message);
		}
	}
}
