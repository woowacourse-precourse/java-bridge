package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class RecordTest {

	@Test
	void 다리_건너기_결과_기록하는_기능() {
		Record record = new Record();
		record.recordOneMove("U", true);
		record.recordOneMove("D", true);
		record.recordOneMove("U", false);
		record.recordOneMove("D", false);
		record.recordOneMove("D", true);
		record.recordOneMove("U", false);
		record.recordOneMove("U", true);
		record.recordOneMove("D", false);

		List<List<String>> result = record.getResult();
		assertThat(result.size()).isEqualTo(8);

		List<List<String>> expected = List.of(
			List.of("U", "O"),
			List.of("D", "O"),
			List.of("U", "X"),
			List.of("D", "X"),
			List.of("D", "O"),
			List.of("U", "X"),
			List.of("U", "O"),
			List.of("D", "X")
		);
		for (int i = 0; i < result.size(); i++) {
			List<String> e = expected.get(i);
			assertThat(result.get(i)).isEqualTo(e);
		}

	}
}