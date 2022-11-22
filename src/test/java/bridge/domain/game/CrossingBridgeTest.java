package bridge.domain.game;

import bridge.domain.map.BridgeMap;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.*;

class CrossingBridgeTest extends NsTest {

	private static CrossingBridge crossingBridge;

	@AfterEach
	@BeforeEach
	void clearMap() {
		BridgeMap.clearBridgeDescription();
	}

	@DisplayName("다리 건너기 기능을 검증한다: resulting fail")
	@Test
	void verify_CrossingBridge_WithPotentialFailure() {
		assertSimpleTest(() -> {
			run("D");
			assertThat(crossingBridge.isCrossComplete()).isEqualTo(BridgeGame.RESULT_FAIL);
		});
	}

	@DisplayName("다리 건너기 기능을 검증한다: resulting success")
	@Test
	void verify_CrossingBridge_WithPotentialSuccess() {
		assertSimpleTest(() -> {
			run("U", "U", "D");
			assertThat(crossingBridge.isCrossComplete()).isEqualTo(BridgeGame.RESULT_SUCCESS);
		});
	}

	@Override
	protected void runMain() {
		try {
			List<String> bridgeMocked = newArrayList("U", "U", "D");
			crossingBridge = CrossingBridge.over(bridgeMocked);
		} catch (Exception ignored) {
		}
	}
}
