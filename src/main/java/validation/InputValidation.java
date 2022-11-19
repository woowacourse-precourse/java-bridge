package validation;


import bridge.OutputView;

public class InputValidation {

	private static OutputView outputView=new OutputView();

	public String userInputBridgeSizeValidation(String user_input_bridge_size){
		if (userInputBridgeSizeValidationTry(user_input_bridge_size)){
			return user_input_bridge_size;
		}
		return "[ERROR]";
	}

	private boolean userInputBridgeSizeValidationTry(String user_input_bridge_size){
		boolean FLAG=true;
		try{
			if (!bridgeSizeSpaceValidation(user_input_bridge_size)){
				throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
			}
		}catch (IllegalArgumentException exception){
			outputView.printArgumentErrorMessage(exception);
			FLAG=false;
		}
		return FLAG;
	}

	private boolean bridgeSizeSpaceValidation(String user_input_bridge_size){
		if (user_input_bridge_size.length()>0){
			return bridgeSizeRegexValidation(user_input_bridge_size);
		}
		return false;
	}

	private boolean bridgeSizeRegexValidation(String user_input_bridge_size){
		if (user_input_bridge_size.matches("^[0-9]*$")){
			return bridgeSizeCorrectValidation(user_input_bridge_size);
		}
		return false;
	}

	private boolean bridgeSizeCorrectValidation(String user_input_bridge_size){
		long bridge_size = Long.parseLong(user_input_bridge_size);
		return 3 <= bridge_size && bridge_size <= 20;
	}
}
