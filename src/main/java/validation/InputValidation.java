package validation;


import bridge.util.OutputView;

public class InputValidation {

	private static OutputView outputView=new OutputView();

	//===================BRIDGE_SIZE_VALIDATION=====================
	public String userInputBridgeSizeValidation(String user_input_bridge_size){
		if (userInputBridgeSizeValidationTry(user_input_bridge_size)){
			return user_input_bridge_size;
		}
		return "[ERROR]";
	}

	private boolean userInputBridgeSizeValidationTry(String user_input_bridge_size){
		boolean FLAG=true;
		try{
			if (!bridgeSizeEmptyValidation(user_input_bridge_size)){
				throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
			}
		}catch (IllegalArgumentException exception){
			outputView.printArgumentErrorMessage(exception);
			FLAG=false;
		}
		return FLAG;
	}

	private boolean bridgeSizeEmptyValidation(String user_input_bridge_size){
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
	//===================BRIDGE_MOVE_VALIDATION=====================
	public String userInputBridgeMoveValidation(String user_input_bridge_move){
		if (userInputBridgeMoveValidationTry(user_input_bridge_move)){
			return user_input_bridge_move;
		}
		return "[ERROR]";
	}

	private boolean userInputBridgeMoveValidationTry(String user_input_bridge_move){
		boolean FLAG=true;
		try {
			if (!bridgeMoveEmptyValidation(user_input_bridge_move)){
				throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D로 입력해야 합니다.");
			}
		}
		catch (IllegalArgumentException exception){
			outputView.printArgumentErrorMessage(exception);
			FLAG=false;
		}
		return FLAG;
	}

	private boolean bridgeMoveEmptyValidation(String user_input_bridge_move){
		if (user_input_bridge_move.length()==1){
			return bridgeMoveRegexValidation(user_input_bridge_move);
		}
		return false;
	}

	private boolean bridgeMoveRegexValidation(String user_input_bridge_move){
		if (user_input_bridge_move.matches("^[A-Z]*$")){
			return bridgeMoveCorrectValidation(user_input_bridge_move);
		}
		return false;
	}

	private boolean bridgeMoveCorrectValidation(String user_input_bridge_move){
		if (user_input_bridge_move.matches("U|D")){
			return true;
		}
		return false;
	}
}
