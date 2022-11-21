package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProgressMapTest {
	ProgressMap progressMap;
	String upInput = "U";
	String downInput = "D";
	boolean moveSuccess = true;
	boolean moveFail = false;

	@BeforeEach
	void setup() {
		progressMap = new ProgressMap();
	}

	@Test
	@DisplayName("성공 시 정상적으로 맵을 업데이트 하는지 테스트")
	void updateMapMoveTest() {
		List<List<String>> expect = new ArrayList<>();
		expect.add(List.of("O", " ", " "));
		expect.add(List.of(" ", "O", "O"));

		progressMap.updateProgressMap(upInput, moveSuccess);
		progressMap.updateProgressMap(downInput, moveSuccess);
		progressMap.updateProgressMap(downInput, moveSuccess);

		assertEquals(expect, progressMap.getProgressMap());
	}

	@Test
	@DisplayName("실패 시 정상적으로 맵을 업데이트 하는지 테스트")
	void updateMapMoveFailedTest() {
		List<List<String>> expect = new ArrayList<>();
		expect.add(List.of("X"));
		expect.add(List.of(" "));

		progressMap.updateProgressMap(upInput, moveFail);

		assertEquals(expect, progressMap.getProgressMap());
	}

	@Test
	@DisplayName("성공 후, 실패 시 정상적으로 맵을 업데이트 하는지 테스트")
	void updateMapMoveFailedTest2() {
		List<List<String>> expect = new ArrayList<>();
		expect.add(List.of("O", " "));
		expect.add(List.of(" ", "X"));

		progressMap.updateProgressMap(upInput, moveSuccess);
		progressMap.updateProgressMap(downInput, moveFail);

		assertEquals(expect, progressMap.getProgressMap());
	}

	@Test
	@DisplayName("맵 길이가 정상적으로 나오는지 테스트")
	void mapSizeTest() {
		int expect = 3;

		progressMap.updateProgressMap(upInput, moveSuccess);
		progressMap.updateProgressMap(upInput, moveSuccess);
		progressMap.updateProgressMap(downInput, moveSuccess);

		assertEquals(expect, progressMap.getMapSize());
	}

	@Test
	@DisplayName("실패한 후에도 맵 길이가 정상적으로 나오는지 테스트")
	void mapSizeTest2() {
		int expect = 2;

		progressMap.updateProgressMap(upInput, moveSuccess);
		progressMap.updateProgressMap(downInput, moveSuccess);

		assertEquals(expect, progressMap.getMapSize());
	}
}
