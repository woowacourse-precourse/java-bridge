package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.domain.BridgeResult;
import bridge.domain.BridgeStatus;
import bridge.domain.GameStatus;
import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.service.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest extends NsTest {

	private final static String UP = "U";
	private final static String DOWN = "D";

	@Test
	@DisplayName("게임 클리어, 계속 테스트")
	void 게임_상태_테스트() {
		GameStatus gameStatus1;
		GameStatus gameStatus2;
		BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));


		gameStatus1 = bridgeGame.isClear();
		bridgeGame.move(UP);
		bridgeGame.move(DOWN);
		bridgeGame.move(DOWN);
		gameStatus2 = bridgeGame.isClear();
		assertThat(gameStatus1).isEqualTo(GameStatus.PASS);
		assertThat(gameStatus2).isEqualTo(GameStatus.CLEAR);
	}


	@Test
	@DisplayName("게임 종료(실패) 테스트")
	void 게임_종료_테스트() {
		BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));

		BridgeResult bridgeResult = new BridgeResult();
		bridgeResult.crossOneBridge(BridgeStatus.FAIL, UP);
		bridgeGame.end(bridgeResult);

		System.out.println(bridgeGame);
		assertThat(output()).contains(
			"[ X ]",
			"[   ]",
			"게임 성공 여부: 실패",
			"총 시도한 횟수: 1"
		);
	}

	@Test
	@DisplayName("게임 재시작 테스트")
	void 게임_재시작_테스트() {
		BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));

		assertThat(bridgeGame.retry("R")).isEqualTo(true);
		assertThat(bridgeGame.retry("Q")).isEqualTo(false);
	}


	@Test
	@DisplayName("게임 다리 이동 테스트")
	void 게임_다리_이동_테스트() {
		BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));

		assertThat(bridgeGame.move(UP)).isEqualTo(BridgeStatus.SUCCESS);
		assertThat(bridgeGame.move(DOWN)).isEqualTo(BridgeStatus.SUCCESS);
		assertThat(bridgeGame.move(UP)).isEqualTo(BridgeStatus.FAIL);
	}


	@Override
	protected void runMain() {

	}
}
