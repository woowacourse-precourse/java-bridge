package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

	@Test
	void move_테스트() {
		List<List<String>> answer = new ArrayList<>();
		answer.add(new ArrayList<>(Arrays.asList("O")));
		answer.add(new ArrayList<>(Arrays.asList(" ")));

		Map map = new Map();
		Bridge bridge = new Bridge(Arrays.asList("U", "U", "D"));
		PlayerBridge playerBridge = new PlayerBridge();
		playerBridge.add("U");

		BridgeGame.move(map, bridge, playerBridge);

		assertEquals(map.getMap(), answer);
	}

	@Test
	void retry_map_초기화_테스트() {
		List<List<String>> mapAnswer = new ArrayList<>();
		mapAnswer.add(new ArrayList<>());
		mapAnswer.add(new ArrayList<>());

		Map map = new Map();
		map.addUp("O");
		map.addDown(" ");
		PlayerBridge playerBridge = new PlayerBridge();
		BridgeGame.retry(map, playerBridge, 1);

		assertEquals(map.getMap(), mapAnswer);
	}

	@Test
	void retry_playerBridge_초기화_테스트() {
		PlayerBridge playerBridge = new PlayerBridge();
		playerBridge.add("U");
		playerBridge.add("U");
		BridgeGame.retry(new Map(), playerBridge, 1);

		assertEquals(playerBridge.getLastIndex(), -1);
	}

	@Test
	void retry_count_증가_테스트() {
		int count = BridgeGame.retry(new Map(), new PlayerBridge(), 1);

		assertEquals(count, 2);
	}

	@Test
	void success_성공_테스트() {
		Map map = new Map();
		for (int i = 0; i < 3; i++) {
			map.addUp("O");
			map.addDown(" ");
		}
		assertTrue(BridgeGame.success(map, 3));
	}

	@Test
	void success_실패_테스트() {
		Map map = new Map();
		for (int i = 0; i < 2; i++) {
			map.addUp("O");
			map.addDown(" ");
		}
		assertFalse(BridgeGame.success(map, 3));
	}

	@Test
	void fail_성공_테스트() {
		Map map = new Map();
		map.addUp("O");
		map.addDown(" ");
		map.addUp(" ");
		map.addDown("X");

		assertTrue(BridgeGame.fail(map));
	}

	@Test
	void fail_실패_테스트() {
		Map map = new Map();
		map.addUp("O");
		map.addDown(" ");
		map.addUp(" ");
		map.addDown("O");

		assertFalse(BridgeGame.fail(map));
	}
}