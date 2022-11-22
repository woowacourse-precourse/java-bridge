package bridge.validation;

import bridge.util.InputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.InputValidation;
import validation.RetryValidation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {

	private final String error_message= "[ERROR]";

	private static InputValidation iv;
	private static RetryValidation rv;


	private static InputView inputView;

	@BeforeAll
	static void initailize(){
		iv=new InputValidation();
		rv=new RetryValidation();
		inputView=new InputView();
	}

	@ParameterizedTest
	@ValueSource(strings = {"1","-23","한글입니다","It's English","21000000000","21",""})
	@DisplayName("유저의_다리길이_입력값_유효성검사")
	void user_input_bridge_length_validation(String source){
		try{
			assertThatThrownBy(()-> {
				//given
				String bridge_size =iv.userInputBridgeSizeValidation(source);
				//when
				if(bridge_size.equals("[ERROR]")) throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
			});
		}catch (IllegalArgumentException e){
			//then
			assertThat(e.getMessage()).isEqualTo("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
		}
	}

	@ParameterizedTest
	@ValueSource(strings = {"a","1217","","u","d","ABC","한글입니당"})
	@DisplayName("유저의_다리길이_입력값_유효성검사")
	void user_input_bridge_move_validation(String source){
		try{
			assertThatThrownBy(()-> {
				//given
				String bridge_move = iv.userInputBridgeMoveValidation(source);
				//when
				if(bridge_move.equals(error_message)) throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
			});
		}catch (IllegalArgumentException e){
			//then
			assertThat(e.getMessage()).isEqualTo("[ERROR] 이동할 칸은 U 또는 D로 입력해야 합니다.");
		}
	}

	@ParameterizedTest
	@ValueSource(strings = {"한글","111111","","r","q","qr","qrQQR"})
	@DisplayName("유저의_재도전_입력값_유효성검사")
	void user_input_retry_condition_validation(String source){
		try{
			assertThatThrownBy(()-> {
				//given
				String bridge_move = rv.userInputRetryConditionValidation(source);
				//when
				if(bridge_move.equals(error_message)) throw new IllegalArgumentException("[ERROR] 재도전 여부는 R 또는 Q로 입력해야 합니다.");
			});
		}catch (IllegalArgumentException e){
			//then
			assertThat(e.getMessage()).isEqualTo("[ERROR] 재도전 여부는 R 또는 Q로 입력해야 합니다.");
		}
	}
}
