package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
	private BridgeGame bridgeGame = new BridgeGame(5);

	@DisplayName("칸을 이동할 때마다, userLocation의 값이 1 증가하고, userPaths의 요소가 하나 추가된다.")
	@Test
	void 칸_이동_시_영향_테스트() {
		List<String> testPaths = List.of("U", "U", "D", "D", "U");

		for (String testPath : testPaths) {
			bridgeGame.move(testPath);
		}

		assertThat(bridgeGame.doesCrossedBridge()).isEqualTo(true);
		assertThat(bridgeGame.getUserPaths().size()).isEqualTo(5);
	}


	@DisplayName("사용자 관련 정보(userLocation, userPaths)가 초기화되고, 시도한 횟수가 1 늘어난다.")
	@Test
	void 재시도_메소드_실행_시_변화() {
		bridgeGame.move("U");
		bridgeGame.move("U");
		bridgeGame.move("D");

		bridgeGame.retry();

		assertThat(bridgeGame.getUserPaths().size()).isEqualTo(0);
		assertThat(bridgeGame.getTryCount()).isEqualTo(2);
	}
}
