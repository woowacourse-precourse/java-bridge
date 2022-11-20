package service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeSize;
import bridge.MapRenderer;
import dto.BridgeDto;
import dto.GameCommandDto;
import dto.IndexDto;
import dto.MapDto;
import dto.MovingDto;
import repository.Bridge;
import repository.PlayCount;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private boolean isSuccess = false;

	public BridgeDto initBridge(int size) {
		BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		BridgeSize bridgeSize = new BridgeSize(size);
		return new Bridge(bridgeMaker.makeBridge(bridgeSize.getBridgeSize())).toBridgeDto();
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 */
	public MapDto move(BridgeDto bridgeDto, IndexDto indexDto, MovingDto movingDto) {
		boolean isCorrect = bridgeDto.getCellOfIndex(indexDto.getIndex()).equals(movingDto.getMoving());
		return new MapRenderer(bridgeDto.getPartOfBridge(indexDto.getIndex()), isCorrect).toMapDto();
	}

	public boolean isFinish(MapDto mapDto, BridgeDto bridgeDto, IndexDto indexDto) {
		if (mapDto.getNumberOfCorrect() == indexDto.getIndex() + 1) {
			if (mapDto.getNumberOfCorrect() == bridgeDto.getBridgeSize()) {
				isSuccess = true;
				return true;
			}
			return false;
		}
		return true;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 */
	public MapDto retry(GameCommandDto gameCommandDto, MapDto mapDto) {
		if (gameCommandDto.getGameCommand().equals("R")) {
			PlayCount.getInstance().addCount();
			return new MapDto("");
		}
		return mapDto;
	}

	public boolean isSuccess() {
		return isSuccess;
	}
}
