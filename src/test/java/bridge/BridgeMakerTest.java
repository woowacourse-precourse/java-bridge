package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
	@DisplayName("다리가 정상적으로 생성되는지 확인한다.")
	@Test
	void makeBridge() {
		//given
		BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 1));

		//when
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(3);

		//then
		assertThat(bridge).containsExactly("U", "D", "U");
	}

	@DisplayName("다리가 비정상적으로 생성되면 에러를 발생한다.")
	@Test
	void makeNoBridge() {
		//given
		BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 2));

		//when
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

		//then
		assertThatThrownBy(() -> {List<String> bridge = bridgeMaker.makeBridge(3);}).isInstanceOf(IllegalArgumentException.class);
	}
}