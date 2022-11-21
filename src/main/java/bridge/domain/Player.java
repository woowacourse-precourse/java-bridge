package bridge.domain;

public class Player {

	private int tryCount = 0;
	private String gameResult;
	private BridgeResult bridgeResult = new BridgeResult();

	public Player() {
		this.tryCount++;
	}
	public void gameClear(BridgeResult bridgeResult) {
		this.bridgeResult = bridgeResult;
		this.gameResult = GameStatus.CLEAR.getMessage();
	}

	public void gameQuit(BridgeResult bridgeResult){
		this.bridgeResult = bridgeResult;
		this.gameResult = GameStatus.END.getMessage();
	}

	public void addRetry() {
		this.tryCount++;
		this.bridgeResult = new BridgeResult();
	}

	@Override
	public String toString() {
		return String.format("%s\n게임 성공 여부: %s\n총 시도한 횟수: %d", bridgeResult, gameResult, tryCount);
	}
}
