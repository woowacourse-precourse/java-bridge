package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.game.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;

public class ControllerTest extends NsTest {

	@DisplayName("다리 건너기 성공 테스트")
	@Test
	void 다리_건너기_성공_테스트() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "D", "U", "U");
			assertThat(output()).contains(
				"이동할 칸을 선택해 주세요. (위: U, 아래: D)",
				"[   | O | O ]",
				"[ O |   |   ]",
				"게임 성공 여부: 성공"
			);

			int upSideIndex = output().indexOf("[   | O | O ]");
			int downSideIndex = output().indexOf("[ O |   |   ]");
			assertThat(upSideIndex).isLessThan(downSideIndex);

			assertThat(BridgeGame.isClearCrossBridge()).isTrue();
			assertThat(BridgeGame.isFailCrossBridge()).isFalse();
		}, 0, 1, 1);
	}

	@DisplayName("다리 건너기 실패, 재시작 x")
	@Test
	void 다리_건너기_실패_후_종료_테스트() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "D", "D", "Q");
			assertThat(output()).contains(
				"이동할 칸을 선택해 주세요. (위: U, 아래: D)",
				"[   |   ]",
				"[ O | X ]",
				"게임 성공 여부: 실패"
			);

			int upSideIndex = output().indexOf("[   |   ]");
			int downSideIndex = output().indexOf("[ O | X ]");
			assertThat(upSideIndex).isLessThan(downSideIndex);

		}, 0, 1, 1);
	}

	@DisplayName("다리 건너기 실패, 재시작 o")
	@Test
	void 다리_건너기_실패_후_재시작_테스트() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "D", "D", "R", "D", "U", "U");
			assertThat(output()).contains(
				"이동할 칸을 선택해 주세요. (위: U, 아래: D)",
				"[   |   ]",
				"[ O | X ]",
				"게임을 다시 시도할지 여부를 입력해 주세요. (재시도: R, 종료: Q)",
				"게임 성공 여부: 성공"
			);

			int upSideIndex = output().indexOf("[   |   ]");
			int downSideIndex = output().indexOf("[ O | X ]");
			assertThat(upSideIndex).isLessThan(downSideIndex);

		}, 0, 1, 1);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
