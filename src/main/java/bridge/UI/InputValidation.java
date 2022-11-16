package bridge.UI;

public class InputValidation {

    OutputView outputView = new OutputView();

    public boolean validateBridgeLength(String input){
        boolean isAllRight = true;
        try{
            validateBridgeLengthInputIsNumber(input);
            validateBridgeLengthInRange(input);
        }catch(IllegalArgumentException ex){
            isAllRight = false;
        }

        return isAllRight;
    }

    public void validateBridgeLengthInRange(String input){
        int bridgeLength = Integer.parseInt(input);
        if(!(3 <= bridgeLength && bridgeLength <= 20)){
            String errorMessage = "[ERROR] 다리의 길이는 3 이상 20 이하여야 합니다.";
            errorProcess(errorMessage);
        }
    }

    public void validateBridgeLengthInputIsNumber(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException ex){
            String errorMessage = "[ERROR] 다리 길이에 대한 입력은 숫자여야 합니다.";
            errorProcess(errorMessage);
        }
    }

    public boolean validatePlayingInput(String input){
        boolean isAllRight = true;
        try{
            validatePlayingInputIsRight(input);
        }catch(IllegalArgumentException ex){
            isAllRight = false;
        }
        return isAllRight;
    }

    public void validatePlayingInputIsRight(String input){
        boolean isNotRightInput = !(input.equals("U") || input.equals("D"));
        if(isNotRightInput){
            String errorMessage = "[ERROR] 게임을 진행할 때는 U 또는 D만 입력할 수 있습니다.";
            errorProcess(errorMessage);
        }
    }

    private void errorProcess(String errorMessage){
        outputView.printStatement(errorMessage);
        throw new IllegalArgumentException();
    }
}
