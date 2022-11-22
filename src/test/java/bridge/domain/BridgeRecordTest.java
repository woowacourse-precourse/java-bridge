package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import bridge.domain.Bridge;
import bridge.domain.BridgeRecord;

public class BridgeRecordTest {

	@DisplayName("addBoard는 주어진 Bridge와 다리 발판을 비교하여 정답여부와 위아래 위치를 List에 추가하고 정답여부를 반환한다")
	@Test
	void addBoard() {
		Bridge bridge = new Bridge(List.of("U", "D", "U"));

		BridgeRecord record = new BridgeRecord();
		boolean result = record.addBoard(bridge, "U");
		List<String[]> boards = record.getBoards();

		assertThat(boards).hasSize(1);
		assertThat(boards.get(0)).isEqualTo(new String[] {"U", "O"});
		assertThat(result).isTrue();
	}

	@DisplayName("deleteBoard는 BridgeRecord의 boards의 마지막 요소를 제거한다")
	@Test
	void deleteBoard() {
		Bridge bridge = new Bridge(List.of("U", "D", "U"));

		BridgeRecord record = new BridgeRecord();
		record.addBoard(bridge, "U");
		record.deleteBoard();

		assertThat(record.getBoards()).hasSize(0);
	}

	@DisplayName("increaseTry는 tryCount를 1 증가 시킨다")
	@Test
	void increaseTry() {
		BridgeRecord record = new BridgeRecord();
		record.increaseTry();

		assertThat(record.getTryCount()).isEqualTo(2);
	}

}
