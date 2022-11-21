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

	public String retryOrGiveUP(String user_input_condition, OutputView outputView){
		if (user_input_condition.equals("Q")){
			outputView.printResult();
			return "Q";
		}
		return "R";
	}

}
