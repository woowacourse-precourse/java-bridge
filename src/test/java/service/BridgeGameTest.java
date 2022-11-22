package service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.Bridge;
import bridge.MoveResult;
import bridge.PlayCount;
import dto.BridgeResponseDto;
import dto.BridgeSizeRequestDto;
import dto.GameCommandRequestDto;
import dto.MoveResultResponseDto;
import dto.MovingRequestDto;

class BridgeGameTest {

	@DisplayName("사용자의 입력 모음이 초기화 되는지 확인한다.")
	@Test
	void initMovingStack() {
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.initMovingStack();
		bridgeGame.move(new MovingRequestDto("U"));
		bridgeGame.move(new MovingRequestDto("D"));
		bridgeGame.initMovingStack();
		bridgeGame.move(new MovingRequestDto("U"));
		assertThat(
			bridgeGame.produceResult(new BridgeResponseDto(new Bridge(List.of("U", "D", "U")))).getMap()).isEqualTo(
			new MoveResultResponseDto(new MoveResult(List.of("U", "D", "D"), List.of("U"))).getMap());
	}

	@DisplayName("다리가 정상적으로 생성되는지 확인한다.")
	@Test
	void initBridge() {
		BridgeGame bridgeGame = new BridgeGame();
		assertEquals(3, bridgeGame.initBridge(new BridgeSizeRequestDto(3)).getBridge().size());
	}

	@DisplayName("사용자의 입력이 정상적으로 추가되는지 확인한다.")
	@Test
	void move() {
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.initMovingStack();
		bridgeGame.move(new MovingRequestDto("U"));
		bridgeGame.move(new MovingRequestDto("D"));
		assertThat(
			bridgeGame.produceResult(new BridgeResponseDto(new Bridge(List.of("U", "D", "U")))).getMap()).isEqualTo(
			new MoveResultResponseDto(new MoveResult(List.of("U", "D", "D"), List.of("U", "D"))).getMap());
	}

	@DisplayName("사용자의 입력에 대해 제대로 결과를 출력하는지 확인한다.")
	@Test
	void produceResult() {
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.initMovingStack();
		bridgeGame.move(new MovingRequestDto("U"));
		assertEquals(1,
			bridgeGame.produceResult(new BridgeResponseDto(new Bridge(List.of("U", "D", "U")))).getNumberOfCorrect());
	}

	@DisplayName("게임이 끝났을 때 결과를 제대로 반환하는지 확인한다.")
	@Test
	void checkGameIsEnd() {
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.initMovingStack();
		assertThat(bridgeGame.checkGameIsEnd(
				new MoveResultResponseDto(new MoveResult(List.of("U", "D", "U"), List.of("U", "D", "U"))))
			.getMap()).isEqualTo("[ O |   | O ]\n[   | O |   ]");
	}

	@DisplayName("총 게임 횟수를 정상적으로 반환하는지 확인한다.")
	@Test
	void makePlayCountDto() {
		BridgeGame bridgeGame = new BridgeGame();
		assertThat(bridgeGame.makePlayCountDto().getPlayCount()).isEqualTo(PlayCount.getInstance().getCount());
	}

	@DisplayName("재시작 여부를 정상적으로 반환하는지 확인한다.")
	@Test
	void retry() {
		BridgeGame bridgeGame = new BridgeGame();
		assertTrue(bridgeGame.retry(new GameCommandRequestDto("R")));
	}
}