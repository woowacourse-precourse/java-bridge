package bridge.ui;

public class Validate {
    OutputView outputView = new OutputView();

    public boolean isValidBridgeSize(String input){
        try {
            bridgeSize(input);
        }
        catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return (false);
        }
        return (true);
    }

    public boolean isValidReadMove(String input){
        try {
            readMove(input);
        }
        catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return (false);
        }
        return (true);
    }

    public boolean isValidRetryCommand(String input){
        try {
            retryCommand(input);
        }
        catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return (false);
        }
        return (true);
    }

    private void bridgeSize(String input){
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < 3 || bridgeSize > 20){
            throw new IllegalArgumentException("3 이상 20 이하의 숫자여야 합니다.");
        }
    }

    private void readMove(String input){
        if (!input.equals("U") && !input.equals("D")){
            throw new IllegalArgumentException("입력값은 U 혹은 D 여야 합니다.");
        }
    }

    private void retryCommand(String input){
        if (!input.equals("R") && !input.equals("Q")){
            throw new IllegalArgumentException("입력값은 R 또는 Q 여야 합니다.");
        }
    }

}
