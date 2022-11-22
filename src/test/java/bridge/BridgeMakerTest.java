package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
	@Test
	@DisplayName("입력된 길이로 다리가 만들어지는지 테스트")
	void 다리_입력_길이_유효성_테스트() {
		//given
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		//when
		List<String> bridges = bridgeMaker.makeBridge(3);
		//then
		assertThat(bridges.size()).isEqualTo(3);
	}
}
