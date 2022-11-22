package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

class BridgeMakerTest {

	@Test
	@DisplayName("랜덤 범위가 0~1인 BridgeRandomNumberGenerator를 이용할 경우 예외가 발생하지 않는다. - 성공")
	void makeBridge() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

		assertThatCode(
			() -> bridgeMaker.makeBridge(3)
		).doesNotThrowAnyException();
	}

	@Test
	@DisplayName("bridgeNumberGenerator의 생성 숫자 범위가 0~1이 아닐경우 예외처리된다. - 실패")
	void makeBridgeFailureWhenNotRangeOfRandomNumber() {
		BridgeMaker bridgeMaker = new BridgeMaker(() -> Randoms.pickNumberInRange(2, 3));
		assertThatThrownBy(
			() -> bridgeMaker.makeBridge(3)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
