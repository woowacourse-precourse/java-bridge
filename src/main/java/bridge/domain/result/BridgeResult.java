package bridge.domain.result;

public class BridgeResult {
	private int countOfAttemps; //시도한 횟수
	private boolean isSuccess;
	private String map;

	public BridgeResult() {
		this.countOfAttemps = 1;
		this.isSuccess = false;
		this.map = "";
	}

	public void addCountOfAttemps(int moveIndex) {
		if(moveIndex == 0) {
			countOfAttemps++;
		}
	}

	public void gameSuccess() {
		isSuccess = true;
	}

	public void updateMap(String map) {
		this.map = map;
	}


	public int getCountOfAttemps() {
		return countOfAttemps;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public String getMap() {
		return map;
	}
}
