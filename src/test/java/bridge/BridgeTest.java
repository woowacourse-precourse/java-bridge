package bridge;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
	@DisplayName("다리길이는 숫자만 입력 가능하다.")
	@Test
	void checkCreateBridgeSize(){
		assertThatThrownBy(()-> Validation.validationConvertBridgeSize("j"))
			.isInstanceOf(IllegalArgumentException.class);
	}
	@DisplayName("다리길이는 3~20사이의 숫자만 가능하다.")
	@Test
	void checkBridgeSizeRange(){
		assertThatThrownBy(()-> Validation.validationCheckBridgeSizeRange(25))
			.isInstanceOf(IllegalArgumentException.class);
	}
	@DisplayName("각 칸은 U(위) D(아래)만 입력 가능하다.")
	@Test
	void checkBlockInput(){
		assertThatThrownBy(()-> Validation.validationUpOrDown("B"))
			.isInstanceOf(IllegalArgumentException.class);
	}
	@DisplayName("다리게임 실패시, R(재시작) Q(종료)만 입력 가능하다.")
	@Test
	void checkRestartOrQuit(){
		assertThatThrownBy(()->Validation.validationRestartOrQuit("U"))
			.isInstanceOf(IllegalArgumentException.class);
	}


}
