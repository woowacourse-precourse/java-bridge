package controller;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class GameControllerTest extends NsTest {

	@DisplayName("예외를 처리할 수 있는지 검증한다.")
	@Test
	void controlAbnormal() {
		assertRandomNumberInRangeTest(() -> {
			//given, when
			run("3", "R", "U", "D", "U");
			//then
			assertThat(output()).contains(
				"[ERROR]",
				"이동할 칸을 선택해주세요."
			);
		}, 1, 0, 1);
	}

	@DisplayName("정상적으로 실행되는지 검증한다.")
	@Test
	void controlNormal() {
		assertRandomNumberInRangeTest(() -> {
			//given, when
			run("4", "U", "D", "U", "D");
			//then
			assertThat(output()).contains(
				"최종 게임 결과",
				"게임 성공 여부: 성공",
				"총 시도한 횟수: "
			);
		}, 1, 0, 1, 0);
	}

	@Override
	protected void runMain() {
		GameController gameController = new GameController();
		gameController.control();
	}
}