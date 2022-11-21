package bridge.domain;

import static bridge.Constants.DOWN;
import static bridge.Constants.UP;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

	private BridgeGame bridgeGame;

	@BeforeEach
	void init() {
		List<String> bridgeInput = Arrays.asList(UP, DOWN, UP);
		bridgeGame = new BridgeGame(bridgeInput);
	}

	@Test
	@DisplayName("플레이어를 이동시킨면 위치가 변한다.")
	void 플레이어_이동_테스트() {
		//given
		Player player = bridgeGame.getPlayer();
		int currentLocation = player.getCurrentLocation();
		//when
		bridgeGame.move(UP);
		int nextLocation = currentLocation + 1;
		//then
		assertThat(bridgeGame.getPlayer().getCurrentLocation()).isEqualTo(nextLocation);
	}

	@Test
	@DisplayName("게임 재시작시 플레이어는 초기화된다.")
	void 재시작_플레이어_초기화_테스트() {
		//given
		Player currentPlayer = bridgeGame.getPlayer();
		//when
		bridgeGame.retry();
		Player nextPlayer = bridgeGame.getPlayer();
		//then
		assertThat(currentPlayer).isNotEqualTo(nextPlayer);
	}

	@Test
	@DisplayName("게임 재시작시 다리는 그대로여야한다.")
	void 재시작_다리_유지_테스트() {
		//given
		Bridge currentBridge = bridgeGame.getBridge();
		//when
		bridgeGame.retry();
		Bridge nextBridge = bridgeGame.getBridge();
		//then
		assertThat(currentBridge).isEqualTo(nextBridge);
	}
}
