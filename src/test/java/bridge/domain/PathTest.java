package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PathTest {
	@Test
	void 숫자에_따른_방향_반환_테스트() {
		assertThat(Path.getPath(0)).isEqualTo(Path.D.name());
		assertThat(Path.getPath(1)).isEqualTo(Path.U.name());
	}
}
