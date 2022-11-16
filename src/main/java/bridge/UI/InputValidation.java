package bridge.UI;

public class InputValidation {

    OutputView outputView = new OutputView();

    public void validateBridgeLength(int bridgeLength){
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

    private void errorProcess(String errorMessage){
        outputView.printStatement(errorMessage);
        throw new IllegalArgumentException();
    }
}
