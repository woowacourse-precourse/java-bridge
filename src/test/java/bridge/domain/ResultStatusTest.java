package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultStatusTest {

	@Test
	@DisplayName("파라미터끼리 동일하면 성공, 아니면 실패")
	void makeResultStatusTest() {
		ResultStatus successResult = ResultStatus.makeResultStatus("U", "U");
		ResultStatus failResult = ResultStatus.makeResultStatus("U", "D");
		Assertions.assertThat(successResult).isEqualTo(ResultStatus.SUCCESS);
		Assertions.assertThat(failResult).isEqualTo(ResultStatus.FAILURE);
	}
}
