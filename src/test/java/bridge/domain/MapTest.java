package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

	Map map;
	List<List<String>> mapAnswer;

	@BeforeEach
	void a() {
		map = new Map();
		mapAnswer = new ArrayList<>();
		mapAnswer.add(new ArrayList<>());
		mapAnswer.add(new ArrayList<>());
	}

	@Test
	void init_테스트() {
		map.getMap().get(0).add("O");
		map.getMap().get(1).add(" ");
		map.init();

		assertEquals(map.getMap(), mapAnswer);
	}

	@Test
	void addUp_테스트() {
		mapAnswer.get(0).add("O");
		map.addUp("O");

		assertEquals(map.getMap(), mapAnswer);
	}

	@Test
	void addDown_테스트() {
		mapAnswer.get(1).add(" ");
		map.addDown(" ");

		assertEquals(map.getMap(), mapAnswer);
	}

	@Test
	void getSize_테스트() {
		map.addUp("O");
		map.addUp(" ");
		map.addDown(" ");
		map.addDown("O");

		assertEquals(map.getSize(), 2);
	}

	@Test
	void containX_true_테스트() {
		map.addUp("O");
		map.addUp("X");
		map.addDown(" ");
		map.addDown(" ");
		assertTrue(map.containX());
	}

	@Test
	void containX_false_테스트() {
		map.addUp("O");
		map.addUp(" ");
		map.addDown(" ");
		map.addDown("O");
		assertFalse(map.containX());
	}
}