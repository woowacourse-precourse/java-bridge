package bridge.domain;

import static bridge.Constants.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRecordTest {
	@Test
	@DisplayName("이동의 성공,실패 여부 기록 테스트")
	void 플레이어_이동_기록_테스트() {
		//given
		GameRecord gameRecord = new GameRecord();
		//when
		gameRecord.recordSuccess(UP);
		gameRecord.recordSuccess(DOWN);
		gameRecord.recordFail(UP);
		String expected = "[ O |   | X ]" + "\n" + "[   | O |   ]";
		//then
		assertThat(gameRecord.toString()).isEqualTo(expected);
	}

	@Test
	@DisplayName("재시작할 경우 기록이 초기화된다.")
	void 재시작_기록_초기화_테스트() {
		//given
		GameRecord gameRecord = new GameRecord();
		gameRecord.recordSuccess(UP);
		//when
		gameRecord.retry();
		String nextRecord = gameRecord.toString();
		//then
		assertThat(nextRecord).isEqualTo("[  ]"+"\n"+"[  ]");
	}
}
