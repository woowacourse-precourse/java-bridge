package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
	@DisplayName("다리가 정상적으로 생성되는지 확인한다.")
	@Test
	void makeBridge() {
		//given
		BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 1, 1));
		//when
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(4);
		//then
		assertThat(bridge).containsExactly("U", "D", "U", "U");
	}
}