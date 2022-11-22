package bridge.domain;

import static bridge.domain.ResultMessageStatus.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultMessageStatusTest {

	@Test
	@DisplayName("각 파라미터마다 동일한 경우와 아닌 경우의 결과 메시지")
	void makeResultMessageStatusTest() {
		ResultMessageStatus upSuccess = makeResultMessageStatus("U", "U");
		ResultMessageStatus upFail = makeResultMessageStatus("U", "D");
		ResultMessageStatus downSuccess = makeResultMessageStatus("D", "D");
		ResultMessageStatus downFail = makeResultMessageStatus("D", "U");
		Assertions.assertThat(upSuccess).isEqualTo(UP_SUCCESS_RESULT);
		Assertions.assertThat(upFail).isEqualTo(DOWN_FAILURE_RESULT);
		Assertions.assertThat(downSuccess).isEqualTo(DOWN_SUCCESS_RESULT);
		Assertions.assertThat(downFail).isEqualTo(UP_FAILURE_RESULT);
	}
}
