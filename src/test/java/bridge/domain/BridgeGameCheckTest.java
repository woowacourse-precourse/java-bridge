package bridge.domain;

import bridge.enums.UpDown;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameCheckTest {
	private BridgeGame bridgeGame;

	@BeforeEach
	void beforeEach() {
		bridgeGame = new BridgeGame(List.of(UpDown.UP.getDirection(), UpDown.DOWN.getDirection(), UpDown.DOWN.getDirection()));
	}

	@DisplayName("isMatchingDirection 정상 테스트")
	@Test
	void isMatchingDirectionTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		Assertions.assertThat(BridgeGameCheck.isMatchingDirection(bridgeGame))
				.isTrue();
	}

	@DisplayName("isMatchingDirection 비정상 테스트")
	@Test
	void isMatchingDirectionExceptionTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.UP.getDirection());
		Assertions.assertThat(BridgeGameCheck.isMatchingDirection(bridgeGame))
				.isFalse();
	}

	@DisplayName("게임이 아직 끝나지 않았거나 잘못된 방향을 입력한 경우는 게임을 진 것이다.")
	@Test
	void isGameLossTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		Assertions.assertThat(BridgeGameCheck.isGameLoss(bridgeGame))
				.isTrue();
	}

	@DisplayName("게임을 이겼으면 isGameLoss 는 false 를 리턴해야 한다.")
	@Test
	void isGameLossExceptionTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		Assertions.assertThat(BridgeGameCheck.isGameLoss(bridgeGame))
				.isFalse();
	}

	@DisplayName("아직 다리 끝에 도달하지 않았으면 게임이 끝난 것이 아니다.")
	@Test
	void isNotFinishTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		Assertions.assertThat(BridgeGameCheck.isNotFinish(bridgeGame))
				.isTrue();
	}

	@DisplayName("다리 끝에 도달했고 방향이 다 일치하면 게임을 이긴 것이다.")
	@Test
	void isGameWinTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		Assertions.assertThat(BridgeGameCheck.isGameWin(bridgeGame))
				.isTrue();
	}

	@DisplayName("방향이 다 일치해도 다리 끝에 도달하지 않았으면 게임이 끝난것이 아니다.")
	@Test
	void isGameWinExceptionTest() {
		bridgeGame.move(UpDown.UP.getDirection());
		bridgeGame.move(UpDown.DOWN.getDirection());
		Assertions.assertThat(BridgeGameCheck.isGameWin(bridgeGame))
				.isFalse();
	}
}