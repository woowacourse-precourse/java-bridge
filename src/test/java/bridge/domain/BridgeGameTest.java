package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.controller.GameState;
import bridge.vo.Bridge;
import bridge.vo.UserPlayer;

public class BridgeGameTest {
	BridgeGame bridgeGame;
	UserPlayer userPlayer;

	@BeforeEach
	public void initialize() {
		UserPlayer userPlayer = new UserPlayer();
		Bridge bridge = new Bridge(List.of("U", "D", "U", "U", "D"));
		bridgeGame = new BridgeGame(userPlayer, bridge);
	}

	@DisplayName("사용자가 움직인 결과의 반환값 확인 테스트")
	@Test
	void move() {
		assertThat(bridgeGame.move("U")).isEqualTo(GameState.CONTINUATION);
	}

	@DisplayName("사용자가 선택한 값이 갈 수 있는지 여부 판단 테스트")
	@Test
	void isSuccessfulMove() {
		assertThat(bridgeGame.isSuccessfulMove("D")).isEqualTo(false);
	}

	@DisplayName("게임진행 여부 값 입력 시 올바른 상태출력 확인 테스트")
	@Test
	void selectGameContinue() {
		assertThat(bridgeGame.selectGameContinue("Q")).isEqualTo(GameState.FAIL_END);
	}
}
