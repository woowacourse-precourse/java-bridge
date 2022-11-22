package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayCountTest {

	@DisplayName("총 게임 횟수를 구한다.")
	@Test
	void addCount() {
		//given
		PlayCount.getInstance().addCount();
		//when, then
		assertThat(PlayCount.getInstance().getCount()).isEqualTo(2);
	}
}