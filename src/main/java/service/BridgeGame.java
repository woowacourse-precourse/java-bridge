package service;

import bridge.Bridge;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeSize;
import bridge.GameCommand;
import bridge.MapRenderer;
import dto.BridgeDto;
import dto.BridgeSizeDto;
import dto.GameCommandDto;
import dto.IndexDto;
import dto.MapDto;
import dto.MovingDto;
import repository.PlayCount;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	/**
	 * 입력 받은 다리 길이로 다리를 생성하는 메서드
	 */
	public BridgeDto initBridge(BridgeSizeDto bridgeSizeDto) {
		BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		BridgeSize bridgeSize = new BridgeSize(bridgeSizeDto.getBridgeSize());
		return new Bridge(bridgeMaker.makeBridge(bridgeSize.getBridgeSize())).toBridgeDto();
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 */
	public MapDto move(BridgeDto bridgeDto, IndexDto indexDto, MovingDto movingDto) {
		return new MapRenderer(bridgeDto, indexDto, movingDto).toMapDto();
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 */
	public boolean retry(GameCommandDto gameCommandDto) {
		GameCommand gameCommand = new GameCommand(gameCommandDto.getGameCommand());
		if (gameCommand.isRetry()) {
			PlayCount.getInstance().addCount();
			return true;
		}
		return false;
	}
}
