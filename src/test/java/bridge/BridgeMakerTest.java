package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
	private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

	@DisplayName("생성한 다리의 리스트 요소는 'U'와 'D'로 이루어져 있다")
	@Test
	void 생성된_다리의_요소_테스트() {


		assertThat(bridgeMaker.makeBridge(10)).containsOnly("U", "D");
	}

	@DisplayName("파라미터로 전달받은 다리의 길이와 실제 생성된 다리의 길이가 같다.")
	@Test
	void 생성된_다리의_길이가_올바른지_확인() {
		int bridgeSize = 10;
		assertThat(bridgeMaker.makeBridge(bridgeSize).size()).isEqualTo(bridgeSize);
	}
}
