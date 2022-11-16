package bridge.UI;

public class InputValidation {

    OutputView outputView = new OutputView();

    private void errorProcess(String errorMessage){
        outputView.printStatement(errorMessage);
        throw new IllegalArgumentException();
    }
}
