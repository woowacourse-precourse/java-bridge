package bridge.function;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.move.CompareMove;
import bridge.util.InputView;
import bridge.util.OutputView;
import controller.BridgeController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.InputValidation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

	private final String error_message= "[ERROR]";

	private static InputValidation iv;

	private static InputView inputView;
	private static OutputView outputView;

	private static BridgeMaker bm;
	private static CompareMove cm;
	private static BridgeNumberGenerator bridgeNumberGenerator=new BridgeRandomNumberGenerator();
	private static BridgeController bc;


	@BeforeAll
	static void initailize(){
		iv=new InputValidation();
		inputView=new InputView();
		outputView=new OutputView();
		bm=new BridgeMaker(bridgeNumberGenerator);
		cm=new CompareMove();
		bc=new BridgeController();
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

	@Test
	@DisplayName("다리 움직임 값과 다리 리스트 비교 테스트")
	void crossingTheBridgeResult1(){
		//given
		String bridge_move ="D";
		String list_index ="U";

		//when
		String move_result = cm.compareInputAndIndex(bridge_move, list_index);
		//then
		assertThat(move_result).isEqualTo("OU");
	}

	@Test
	@DisplayName("다리 움직임 값과 다리 리스트 비교 테스트2")
	void crossingTheBridgeResult2(){
		//given
		String bridge_move ="D";
		String list_index ="U";

		//when
		String move_result = cm.compareInputAndIndex(bridge_move, list_index);
		//then
		assertThat(move_result).isEqualTo("XD");
	}
}
