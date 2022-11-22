package validation;

import bridge.util.OutputView;

public class RetryValidation {

	private static final OutputView outputView=new OutputView();
	//===================RETRY_CONDITION_VALIDATION=====================
	public String userInputRetryConditionValidation(String retry_condition){
		if (userInputRetryConditionValidationTry(retry_condition)){
			return retry_condition;
		}
		return "[ERROR]";
	}

	private boolean userInputRetryConditionValidationTry(String retry_condition){
		boolean FLAG=true;
		try {
			if (!retryConditionEmptyValidation(retry_condition)){
				throw new IllegalArgumentException("[ERROR] 재도전 여부는 R 또는 Q로 입력해야 합니다.");
			}
		}catch (IllegalArgumentException exception){
			outputView.printArgumentErrorMessage(exception);
			FLAG=false;
		}
		return FLAG;
	}

	private boolean retryConditionEmptyValidation(String retry_condition){
		if (retry_condition.length()==1){
			return retryConditionRegexValidation(retry_condition);
		}
		return false;
	}

	private boolean retryConditionRegexValidation(String retry_condition){
		if (retry_condition.matches("^[A-Z]*$")){
			return retryConditionCorrect(retry_condition);
		}
		return false;
	}

	private boolean retryConditionCorrect(String retry_condition) {
		return retry_condition.matches("[RQ]");
	}

}
