package bridge.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class RecordTest {

	@Test
	void 다리_건너기_결과_기록하는_기능() {
		Record record = new Record();
		record.recordResult("U", true);
		record.recordResult("D", true);
		record.recordResult("U", false);
		record.recordResult("D", false);
		record.recordResult("D", true);
		record.recordResult("U", false);
		record.recordResult("U", true);
		record.recordResult("D", false);

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