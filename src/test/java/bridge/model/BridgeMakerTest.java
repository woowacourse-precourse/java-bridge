package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMakerTest {
	private static List<String> bridge;

	@BeforeAll public static void initializer() {
		BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		int userInput = 3;
		bridge = bridgeMaker.makeBridge(userInput);
	}

	@DisplayName("입력한 값을 길이로 다리를 만듭니다.") @Test public void 다리만들기테스트1() {
		Assertions.assertThat(bridge).size().isEqualTo(3);
	}

	@DisplayName("입력한 값의 길이로 다리가 제대로 만들어졌는지") @Test public void 다리만들기테스트2() {
		Assertions.assertThat(bridge).size().isNotEqualTo(5);
	}

	@DisplayName("구성요소가 올바른지 테스트합니다.") @Test public void 다리구성요소테스트() {
		for (String symbol : bridge) {
			Assertions.assertThat(symbol).containsAnyOf("U", "D");
		}
	}
}
