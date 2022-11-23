package bridge;

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

    public boolean validateMovingInput(String input){
        boolean isAllRight = true;
        try{
            validateMovingInputIsRight(input);
        }catch(IllegalArgumentException ex){
            isAllRight = false;
        }
        return isAllRight;
    }

    public void validateMovingInputIsRight(String input){
        boolean isNotRightInput = !(input.equals("U") || input.equals("D"));
        if(isNotRightInput){
            String errorMessage = "[ERROR] 게임을 진행할 때는 U 또는 D만 입력할 수 있습니다.";
            errorProcess(errorMessage);
        }
    }

    public boolean validateGameCommandInput(String input){
        boolean isAllRight = true;
        try{
            validateGameCommandIsRight(input);
        }catch(IllegalArgumentException ex){
            isAllRight = false;
        }
        return isAllRight;
    }

    public void validateGameCommandIsRight(String input){
        boolean isNotRightInput = !(input.equals("R") || input.equals("Q"));
        if(isNotRightInput){
            String errorMessage = "[ERROR] 게임 재시작과 종료 여부에는, R 또는 Q만 입력받을 수 있습니다.";
            errorProcess(errorMessage);
        }
    }

    private void errorProcess(String errorMessage){
        outputView.printStatement(errorMessage);
        throw new IllegalArgumentException();
    }
}
