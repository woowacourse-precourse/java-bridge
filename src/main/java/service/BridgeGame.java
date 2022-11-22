package service;

import java.util.List;

import bridge.Bridge;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeSize;
import bridge.GameCommand;
import bridge.MapRenderer;
import bridge.MoveResult;
import bridge.Moving;
import bridge.MovingStack;
import bridge.PlayCount;
import dto.BridgeResponseDto;
import dto.BridgeSizeRequestDto;
import dto.GameCommandRequestDto;
import dto.MapResponseDto;
import dto.MoveResultResponseDto;
import dto.MovingRequestDto;
import dto.PlayCountResponseDto;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private MovingStack movingStack;

	/**
	 * 사용자의 입력 모음을 초기화하는 메서드
	 */
	public void initMovingStack() {
		movingStack = new MovingStack();
	}

	/**
	 * 입력 받은 다리 길이로 다리를 생성하는 메서드
	 */
	public BridgeResponseDto initBridge(BridgeSizeRequestDto bridgeSizeRequestDto) {
		BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		BridgeSize bridgeSize = new BridgeSize(bridgeSizeRequestDto.getBridgeSize());
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getBridgeSize());
		return new BridgeResponseDto(new Bridge(bridge));
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 */
	public void move(MovingRequestDto movingRequestDto) {
		Moving moving = new Moving(movingRequestDto.getMoving());
		movingStack.addMoving(moving.isUpPosition());
	}

	/**
	 * 이동에 따른 결과를 반환할 때 사용하는 메서드
	 */
	public MoveResultResponseDto produceResult(BridgeResponseDto bridgeResponseDto) {
		List<String> bridge = bridgeResponseDto.getBridge();
		return new MoveResultResponseDto(new MoveResult(bridge, movingStack.getMovingStack()));
	}

	/**
	 * 현재 상황에 대한 다리 모양을 반환하는 메서드
	 */
	public MapResponseDto renderMap(BridgeResponseDto bridgeResponseDto) {
		return new MapResponseDto(new MapRenderer(bridgeResponseDto.getBridge(), movingStack.getMovingStack()));
	}

	/*
	 * 게임(라운드)이 끝났는지 확인해주는 메서드
	 */
	public MoveResultResponseDto checkGameIsEnd(MoveResultResponseDto moveResultResponseDto) {
		if (!moveResultResponseDto.isCorrect()) {
			initMovingStack();
			return moveResultResponseDto;
		}
		if (moveResultResponseDto.isSuccess()) {
			return moveResultResponseDto;
		}
		return null;
	}

	/*
	 * 현재 실행 횟수를 반환해주는 메서드
	 */
	public PlayCountResponseDto makePlayCountDto() {
		return new PlayCountResponseDto(PlayCount.getInstance());
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 */
	public boolean retry(GameCommandRequestDto gameCommandRequestDto) {
		GameCommand gameCommand = new GameCommand(gameCommandRequestDto.getGameCommand());
		if (gameCommand.isRetry()) {
			PlayCount.getInstance().addCount();
			return true;
		}
		return false;
	}

	/*
	 * 성공 여부를 반환해주는 메서드
	 */
	public MoveResultResponseDto success(MoveResultResponseDto finalResultResponseDto) {
		if (finalResultResponseDto.isSuccess()) {
			return finalResultResponseDto;
		}
		return null;

	}
}
