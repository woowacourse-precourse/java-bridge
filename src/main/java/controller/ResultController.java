package controller;

import bridge.util.InputView;
import bridge.util.OutputView;

public class ResultController {
	public String resultControllerByResultCondition(String result_condition, InputView inputView,
												  							OutputView outputView){
		if (result_condition.equals("FAIL")){
			return outputView.printRetryCondition(inputView);
		}
		if (result_condition.equals("SUCCESS")){
			return result_condition;
		}

		return "[ERROR]";
	}

}
