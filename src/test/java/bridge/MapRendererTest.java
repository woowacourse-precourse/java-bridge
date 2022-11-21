package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapRendererTest {

	@DisplayName("모두 옳은 칸을 고른 다리의 상태를 정해진 형식대로 만든다.")
	@Test
	void renderSuccess() {
		MapRenderer mapRenderer = new MapRenderer(List.of("U","D","D","U"), List.of("U", "D", "D"));
		assertThat(mapRenderer.toMapResponseDto().getMap()).isEqualTo("[ O |   |   | O ]\n[   | O | O |   ]");
	}

	@DisplayName("틀린 칸을 고른 다리의 상태를 정해진 형식대로 만든다.")
	@Test
	void renderFail() {
		MapRenderer mapRenderer = new MapRenderer(List.of("U","D","D","U"), List.of("U","D","D","D"));
		assertThat(mapRenderer.toMapResponseDto().getMap()).isEqualTo("[ O |   |   |   ]\n[   | O | O | X ]");
	}
}