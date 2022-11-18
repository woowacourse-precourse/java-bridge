package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MapTest {

	static Map map = new Map();
	static StringBuilder downstairs = new StringBuilder();
	static StringBuilder upstairs = new StringBuilder();

	@DisplayName("footPrint 리스트를 입력하면 upstair과 downstair의 상태를 변경시킨다. 그리고 각 층의 상태를 getter 메서드로 불러온다.")
	@Nested
	class GetStairsTest {

		@Test
		void case1() {
			List<String> footPrints = List.of(FootPrint.RIGHT.getFootPrint(), FootPrint.Blank.getFootPrint());

			map.drawMap(footPrints);
			downstairs.append(FootPrint.RIGHT.getFootPrint());
			upstairs.append(FootPrint.Blank.getFootPrint());

			String down = downstairs.toString();
			String up = upstairs.toString();

			System.out.printf("[%s]%n", down.substring(0, down.length() - 1));
			System.out.printf("[%s]%n", up.substring(0, up.length() - 1));

			assertEquals(map.getDownstairs(), down.substring(0, down.length() - 1));
			assertEquals(map.getUpstairs(), up.substring(0, up.length() - 1));
		}

		@Test
		void case2() {
			List<String> footPrints = List.of(FootPrint.Blank.getFootPrint(), FootPrint.RIGHT.getFootPrint());

			map.drawMap(footPrints);
			downstairs.append(FootPrint.Blank.getFootPrint());
			upstairs.append(FootPrint.RIGHT.getFootPrint());

			String down = downstairs.toString();
			String up = upstairs.toString();

			System.out.printf("[%s]%n", down.substring(0, down.length() - 1));
			System.out.printf("[%s]%n", up.substring(0, up.length() - 1));

			assertEquals(map.getDownstairs(), down.substring(0, down.length() - 1));
			assertEquals(map.getUpstairs(), up.substring(0, up.length() - 1));
		}

		@Test
		void case3() {
			List<String> footPrints = List.of(FootPrint.WRONG.getFootPrint(), FootPrint.Blank.getFootPrint());

			map.drawMap(footPrints);
			downstairs.append(FootPrint.WRONG.getFootPrint());
			upstairs.append(FootPrint.Blank.getFootPrint());

			String down = downstairs.toString();
			String up = upstairs.toString();

			System.out.printf("[%s]%n", down.substring(0, down.length() - 1));
			System.out.printf("[%s]%n", up.substring(0, up.length() - 1));

			assertEquals(map.getDownstairs(), down.substring(0, down.length() - 1));
			assertEquals(map.getUpstairs(), up.substring(0, up.length() - 1));
		}

		@Test
		void case4() {
			List<String> footPrints = List.of(FootPrint.Blank.getFootPrint(), FootPrint.WRONG.getFootPrint());

			map.drawMap(footPrints);
			downstairs.append(FootPrint.Blank.getFootPrint());
			upstairs.append(FootPrint.WRONG.getFootPrint());

			String down = downstairs.toString();
			String up = upstairs.toString();

			System.out.printf("[%s]%n", down.substring(0, down.length() - 1));
			System.out.printf("[%s]%n", up.substring(0, up.length() - 1));

			assertEquals(map.getDownstairs(), down.substring(0, down.length() - 1));
			assertEquals(map.getUpstairs(), up.substring(0, up.length() - 1));
		}

	}
}
