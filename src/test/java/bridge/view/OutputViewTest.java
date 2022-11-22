package bridge.view;

import bridge.dto.GameResultDto;
import bridge.dto.MoveCommandDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class OutputViewTest {
	private static OutputView outputView;
	private static MoveCommandDto moveUpDto;
	private static MoveCommandDto moveDownDto;
	private static MoveCommandDto moveDownGameFailDto;
	private static MoveCommandDto moveFinishDto;
	private static MoveCommandDto moveFinishFailDto;
	private static GameResultDto gameResult1SuccessDto;
	private static GameResultDto gameResult1FailDto;
	private static GameResultDto gameResult2Dto;
	private static GameResultDto gameResult2FailDto;

	@BeforeAll static void initializeOutputViewTest() {
		outputView = new OutputView();
		moveUpDto = new MoveCommandDto("U", true, false);
		moveDownDto = new MoveCommandDto("D", true, false);
		moveDownGameFailDto = new MoveCommandDto("D", false, false);
		moveFinishDto = new MoveCommandDto("U", true, true);
		moveFinishFailDto = new MoveCommandDto("U", false, false);
		gameResult1SuccessDto = new GameResultDto(1, true);
		gameResult1FailDto = new GameResultDto(1, false);
		gameResult2Dto = new GameResultDto(2, true);
		gameResult2FailDto = new GameResultDto(2, false);
	}

	@AfterEach void clearOutputView() {
		outputView.checkResetOutput("R");
	}

	@DisplayName("맵 프린트 테스트(게임을 성공한 경우)") @Test void mapPrintTest1() {
		firstTrySuccessInput3();

		Assertions.assertThat(outputView.toString())
			.contains("[ O | O | O ]", "[   |   |   ]");
	}

	@DisplayName("맵 프린트 테스트(게임을 실패한 경우)") @Test void mapPrintTest2() {
		firstTryFailInput3();

		Assertions.assertThat(outputView.toString()).contains("[ O | O |   ]", "[   |   | X ]");
	}

	@DisplayName("맵 프린트 테스트(게임을 실패후 성공)") @Test void mapPrintTest3() {
		firstTryFailInput3();
		firstTrySuccessInput3();

		Assertions.assertThat(outputView.toString()).contains("[ O | O | O ]", "[   |   |   ]");
	}

	@DisplayName("최종결과 출력(최종성공시)") @Test void mapResultTest1() {
		firstTrySuccessInput5();

		Assertions.assertThat(outputView.toString())
			.contains("[ O | O |   |   | O ]", "[   |   | O | O |   ]", "게임 성공 여부: 성공",
				"총 시도한 횟수: 1");
	}

	@DisplayName("최종결과 출력(최종실패시)") @Test void mapResultTest2() {
		firstTryFailInput5();

		Assertions.assertThat(outputView.toString())
			.contains("[ O | O |   |   | X ]", "[   |   | O | O |   ]", "게임 성공 여부: 실패",
				"총 시도한 횟수: 1");
	}

	@DisplayName("실패 후 성공 최종결과 출력(최종성공)") @Test void mapResultTest3() {
		firstTryFailInput5();
		secondTrySuccessInput5();

		Assertions.assertThat(outputView.toString())
			.contains("[ O | O |   |   | O ]", "[   |   | O | O |   ]", "게임 성공 여부: 성공",
				"총 시도한 횟수: 2");
	}

	@DisplayName("실패 후 실패 최종결과 출력(최종실패)") @Test void mapResultTest4() {
		firstTryFailInput5();
		secondTryFailInput5();

		Assertions.assertThat(outputView.toString())
			.contains("[ O | O |   |   | X ]", "[   |   | O | O |   ]", "게임 성공 여부: 실패",
				"총 시도한 횟수: 2");
	}

	private void firstTrySuccessInput3() {
		outputView.checkResetOutput("R");
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveGameResult(gameResult1SuccessDto);
	}

	private void firstTryFailInput3() {
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveDownGameFailDto);
		outputView.receiveGameResult(gameResult1FailDto);
	}

	private void firstTrySuccessInput5() {
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveFinishDto);
		outputView.receiveGameResult(gameResult1SuccessDto);
	}

	private void secondTrySuccessInput5() {
		outputView.checkResetOutput("R");
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveFinishDto);
		outputView.receiveGameResult(gameResult2Dto);
	}

	private void firstTryFailInput5() {
		outputView.checkResetOutput("R");
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveFinishFailDto);
		outputView.receiveGameResult(gameResult1FailDto);
	}

	private void secondTryFailInput5() {
		outputView.checkResetOutput("R");
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveFinishFailDto);
		outputView.receiveGameResult(gameResult2FailDto);
	}
}
