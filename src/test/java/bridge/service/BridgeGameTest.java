package bridge.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.constant.GameConstant;
import bridge.domain.Bridge;
import bridge.domain.Move;
import bridge.domain.User;

class BridgeGameTest {
	private BridgeGame bridgeGame;

	@BeforeEach
	@DisplayName("길이가 5인 다리 게임 생성")
	void bridgeGameInit() {
		Bridge bridge = new Bridge(List.of("U", "U", "D", "D", "D"));
		bridgeGame = new BridgeGame(new User(), bridge);
	}

	@Test
	@DisplayName("현재까지의 지도를 반환해준다. 0 은 아래칸 1은 위칸")
	void currentMap() {
		List<String> map = new ArrayList<>(List.of("U", "U", "U"));
		for (int i = 0; i < 3; i++) {
			bridgeGame.move(Move.find(map.get(i)));
		}
		List<List<String>> currentMap = bridgeGame.currentMap();
		List<String> targetMap = new ArrayList<>(List.of("O", "O", "X"));
		for (int i = 0; i < currentMap.size(); i++) {
			assertThat(currentMap.get(i)).contains(targetMap.get(i));
		}
	}

	@Test
	@DisplayName("클리어 했는지 확인해준다. - 성공")
	void checkClear() {
		List<String> map = new ArrayList<>(List.of("U", "U", "D", "D", "D"));
		for (int i = 0; i < 5; i++) {
			bridgeGame.move(Move.find(map.get(i)));
			if (!bridgeGame.end()) {
				break;
			}
		}
		assertThat(bridgeGame.result()).isEqualTo(GameConstant.CLEAR);
	}

	@Test
	@DisplayName("클리어 했는지 확인해준다. - 실패")
	void checkClearFailure() {
		List<String> map = new ArrayList<>(List.of("U", "U", "U", "U", "D"));
		for (int i = 0; i < 5; i++) {
			bridgeGame.move(Move.find(map.get(i)));
			System.out.println(bridgeGame.result());
			if (!bridgeGame.end()) {
				break;
			}
		}
		assertThat(bridgeGame.result()).isEqualTo(GameConstant.FAIL);
	}

	@Test
	@DisplayName("재시도 횟수를 반환해준다.")
	void retry() {
		List<Integer> retryCounts = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			bridgeGame.retry();
			retryCounts.add(bridgeGame.trialCount());
		}
		assertThat(retryCounts).containsExactly(2, 3, 4);
	}

}
