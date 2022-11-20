package bridge.view;

import bridge.dto.GameResultDto;
import bridge.dto.MoveCommandDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
	@DisplayName("맵 프린트 테스트(게임을 성공한 경우)") @Test void mapPrintTest1() {
		OutputView outputView = new OutputView();
		MoveCommandDto moveUpDto = new MoveCommandDto("U", true, false);
		MoveCommandDto moveDownDto = new MoveCommandDto("D", true, false);
		MoveCommandDto moveFinishDto = new MoveCommandDto("U", true, true);

		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveFinishDto);

		System.out.println(outputView);
		Assertions.assertThat(outputView.toString())
			.contains("[ O |   |   | O ]", "[   | O | O |   ]");
	}

	@DisplayName("맵 프린트 테스트(게임을 실패한 경우)") @Test void mapPrintTest2() {
		OutputView outputView = new OutputView();
		MoveCommandDto moveUpDto = new MoveCommandDto("U", true, false);
		MoveCommandDto moveDownDto = new MoveCommandDto("D", false, false);

		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveDownDto);

		System.out.println(outputView);
		Assertions.assertThat(outputView.toString()).contains("[ O | O |   ]", "[   |   | X ]");
	}

	@DisplayName("최종결과 출력(최종성공시)") @Test void mapResultTest1() {
		OutputView outputView = new OutputView();
		MoveCommandDto moveUpDto = new MoveCommandDto("U", true, false);
		MoveCommandDto moveDownDto = new MoveCommandDto("D", true, false);
		MoveCommandDto moveFinishDto = new MoveCommandDto("U", true, false);
		GameResultDto gameResultDto = new GameResultDto(5, true);

		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveUpDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveDownDto);
		outputView.receiveMoveCommandResult(moveFinishDto);
		outputView.receiveGameResult(gameResultDto);

		System.out.println(outputView);
		Assertions.assertThat(outputView.toString())
			.contains("[ O | O |   |   | O ]", "[   |   | O | O |   ]", "게임 성공 여부: 성공", "총 시도한 횟수: 5");
	}
}
