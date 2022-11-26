package bridge.domain;

import bridge.util.GameConst;
import bridge.view.OutputView;

public class Result {

	private Integer attemptCount;
	private String userFinalResult;

	public Result() {
		this.attemptCount = 0;
	}

	public void organizeResult(boolean userResult) {
		if (userResult) {
			userFinalResult = GameConst.SUCCESS;
			return;
		}
		userFinalResult = GameConst.FAIL;
	}

	public void attemptCountPlusOne() {
		attemptCount++;
	}

	public String findFinalResultToString() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append(OutputView.USER_FINAL_RESULT)
			.append(userFinalResult)
			.append("\n")
			.append(OutputView.USER_TRY_COUNT_PHRASE)
			.append(String.format("%d", attemptCount))
			.toString();
	}

	public boolean isFail() {
		return userFinalResult.equals(GameConst.FAIL);
	}

}
