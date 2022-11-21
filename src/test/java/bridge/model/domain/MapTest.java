package bridge.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MapTest {

	static Map map = new Map();
	static StringBuilder downstairs = new StringBuilder();
	static StringBuilder upstairs = new StringBuilder();

	@DisplayName("footPrint 리스트를 입력하면 upstairs 인스턴스 변수와 downstairs 인스턴스 변수의 상태를 변경시키고 getter 메서드로 불러온다.")
	@ParameterizedTest
	@CsvSource({"RIGHT, BLANK", "BLANK, RIGHT", "WRONG, BLANK", "BLANK, WRONG"})
	void drawMapTest(FootPrint down, FootPrint up) {
		List<String> footPrints = List.of(down.getFootPrint(), up.getFootPrint());

		map.drawMap(footPrints);
		downstairs.append(down.getFootPrint());
		upstairs.append(up.getFootPrint());

		assertEquals(map.getDownstairs(), downstairs.substring(0, downstairs.length() - 1));
		assertEquals(map.getUpstairs(), upstairs.substring(0, upstairs.length() - 1));
	}
}
