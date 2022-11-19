package bridge.function;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import controller.BridgeController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.InputValidation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionTest {

	private final String error_message= "[ERROR]";

	private static InputValidation iv;

	private static InputView inputView;

	private static BridgeMaker bm;
	private static BridgeNumberGenerator bridgeNumberGenerator=new BridgeRandomNumberGenerator();
	@BeforeAll
	static void initailize(){
		iv=new InputValidation();
		inputView=new InputView();
		bm=new BridgeMaker(bridgeNumberGenerator);
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

	@Test
	@DisplayName("다리 생성이 옳바르게 이루어지는가")
	void bridgeMakeByBridgeSizeCorrect(){
		//given&&when
		List<String> bridge_list = bm.makeBridge(12);

		//
		assertThat(bridge_list.size()).isEqualTo(12);
	}

	@Test
	@DisplayName("다리 생성시 값에 따라 옳바르게 U 또는 D가 들어가는지")
	void bridgeMakeByCorrectElement(){
		//given&&when
		List<String> bridge_list = bm.makeBridge(12);

		//then
		if (bridge_list.contains("U")){
			assertThat(bridge_list.contains("U")).isTrue();
		}
		assertThat(bridge_list.contains("D")).isTrue();
	}
}
