package service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.Bridge;
import bridge.PlayCount;
import dto.BridgeResponseDto;
import dto.BridgeSizeRequestDto;
import dto.GameCommandRequestDto;
import dto.MovingRequestDto;

class BridgeGameTest {

	@DisplayName("사용자의 입력 모음이 초기화 되는지 확인한다.")
	@Test
	void initMovingStack() {
		//given
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.initMovingStack();
		bridgeGame.move(new MovingRequestDto("U"));
		bridgeGame.move(new MovingRequestDto("D"));
		bridgeGame.initMovingStack();
		bridgeGame.move(new MovingRequestDto("D"));
		//when, then
		assertFalse(bridgeGame.produceResult(new BridgeResponseDto(new Bridge(List.of("U", "D", "U")))).isCorrect());
	}

	@DisplayName("다리가 정상적으로 생성되는지 확인한다.")
	@Test
	void initBridge() {
		//given
		BridgeGame bridgeGame = new BridgeGame();
		//when, then
		assertEquals(3, bridgeGame.initBridge(new BridgeSizeRequestDto(3)).getBridge().size());
	}

	@DisplayName("사용자의 입력이 정상적으로 추가되는지 확인한다.")
	@Test
	void move() {
		//given
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.initMovingStack();
		//when
		bridgeGame.move(new MovingRequestDto("U"));
		//then
		assertTrue(bridgeGame.produceResult(new BridgeResponseDto(new Bridge(List.of("U", "D", "U")))).isCorrect());
	}

	@DisplayName("사용자의 입력에 대해 제대로 결과를 출력하는지 확인한다.")
	@Test
	void produceResult() {
		//given
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.initMovingStack();
		//when
		bridgeGame.move(new MovingRequestDto("U"));
		//then
		assertTrue(bridgeGame.produceResult(new BridgeResponseDto(new Bridge(List.of("U", "D", "U")))).isCorrect());
	}

	@DisplayName("게임이 끝났을 때 결과를 제대로 반환하는지 확인한다.")
	@Test
	void checkGameIsEnd() {
		//given
		BridgeGame bridgeGame = new BridgeGame();
		bridgeGame.initMovingStack();
		bridgeGame.move(new MovingRequestDto("U"));
		bridgeGame.move(new MovingRequestDto("D"));
		bridgeGame.move(new MovingRequestDto("U"));
		//when, then
		assertThat(bridgeGame.renderMap(new BridgeResponseDto(new Bridge(List.of("U", "D", "U")))).getMap()).isEqualTo(
			"[ O |   | O ]\n[   | O |   ]");
	}

	@DisplayName("총 게임 횟수를 정상적으로 반환하는지 확인한다.")
	@Test
	void makePlayCountDto() {
		//given
		BridgeGame bridgeGame = new BridgeGame();
		//when, then
		assertThat(bridgeGame.makePlayCountDto().getPlayCount()).isEqualTo(PlayCount.getInstance().getCount());
	}

	@DisplayName("재시작 여부를 정상적으로 반환하는지 확인한다.")
	@Test
	void retry() {
		//given
		BridgeGame bridgeGame = new BridgeGame();
		//when, then
		assertTrue(bridgeGame.retry(new GameCommandRequestDto("R")));
	}
}