package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMapTest {

	@DisplayName("모든 방향 일치시 다리 출력 테스트")
	@Test
	void bridgeMapNormalTest() {
		BridgeMap bridgeMap = new BridgeMap(List.of("U", "D", "D"), List.of("U", "D", "D"));
		Assertions.assertThat(bridgeMap.getMap())
				.containsOnly("[ O |   |   ]", "[   | O | O ]");
	}

	@DisplayName("방향 불일치시 다리 출력 테스트")
	@Test
	void bridgeMapExceptionTest() {
		BridgeMap bridgeMap = new BridgeMap(List.of("U", "D", "D"), List.of("U", "D", "U"));
		Assertions.assertThat(bridgeMap.getMap())
				.containsOnly("[ O |   | X ]", "[   | O |   ]");
	}

	@DisplayName("게임 중간 다리 방향 일치시 다리 출력 테스트")
	@Test
	void bridgeMapBeforeEndNormalTest() {
		BridgeMap bridgeMap = new BridgeMap(List.of("U", "D", "D"), List.of("U", "D"));
		Assertions.assertThat(bridgeMap.getMap())
				.containsOnly("[ O |   ]", "[   | O ]");
	}

	@DisplayName("게임 중간 다리 방향 불일치시 다리 출력 테스트")
	@Test
	void bridgeMapBeforeEndExceptionTest() {
		BridgeMap bridgeMap = new BridgeMap(List.of("U", "D", "D"), List.of("U", "U"));
		Assertions.assertThat(bridgeMap.getMap())
				.containsOnly("[ O | X ]", "[   |   ]");
	}
}