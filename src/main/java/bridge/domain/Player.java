package bridge.domain;

public class Player {

	private static final int RETRY_NUMBER = 0;
	private static final String PLAYER_TO_STRING = "%s\n게임 성공 여부: %s\n총 시도한 횟수: %d";
	private int tryCount = 0;
	private String gameResult;
	private BridgeResult bridgeResult = new BridgeResult();

	private int bridgeNumber = 0;


	public Player() {
		this.tryCount++;
	}

	public void gameClear(BridgeResult bridgeResult) {
		this.bridgeResult = bridgeResult;
		this.gameResult = GameStatus.CLEAR.getMessage();
	}

	public void gameQuit(BridgeResult bridgeResult, int bridgeSize) {
		this.bridgeNumber = bridgeSize;
		this.bridgeResult = bridgeResult;
		this.gameResult = GameStatus.END.getMessage();
	}

	public void addRetry() {
		this.bridgeNumber = RETRY_NUMBER;
		this.tryCount++;
		this.bridgeResult = new BridgeResult();
	}

	public int getBridgeNumber() {
		return bridgeNumber;
	}

	public int addBridgeNumber() {
		return bridgeNumber++;
	}

	@Override
	public String toString() {
		return String.format(PLAYER_TO_STRING, bridgeResult, gameResult, tryCount);
	}
}
