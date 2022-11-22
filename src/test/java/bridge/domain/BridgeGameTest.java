package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.BridgeGame;
import bridge.vo.UserPlayer;

public class BridgeGameTest {
	@DisplayName("사용자가 움직인 결과의 반환값 확인 테스트")
	@Test
	void move() {
		//	givne
		UserPlayer userPlayer = new UserPlayer();
		BridgeGameInitialization bridgeGameInitialization = new BridgeGameInitialization();
		BridgeGame bridgeGame = new BridgeGame(userPlayer, bridgeGameInitialization.initBridge());
		// Bridge bridge = bridgeGameInitialization.initBridge();

		//	when
		// assertThat(bridgeGame.move("U")).isInstanceOf(GameState.class);
		//	then
	}

}
