package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import bridge.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRecordTest {
	@Test
	@DisplayName("이동의 성공,실패 여부 기록 테스트")
	void 플레이어_이동_기록_테스트() {
		//given
		GameRecord gameRecord = new GameRecord();
		//when
		gameRecord.recordSuccess(Constants.UP);
		gameRecord.recordSuccess(Constants.DOWN);
		gameRecord.recordFail(Constants.UP);
		String expected = "[ O |   | X ]" + "\n" + "[   | O |   ]";
		//then
		assertThat(gameRecord.toString()).isEqualTo(expected);
	}
}
