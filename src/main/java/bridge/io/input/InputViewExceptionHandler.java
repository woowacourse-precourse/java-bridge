package bridge.io.input;

import bridge.io.output.OutputView;
import bridge.util.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputViewExceptionHandler {

    public String readAndValidate(String question, Validator validator) {
        while (true) {
            try {
                System.out.println(question);
                return validator.validate(readLine());
            } catch (IllegalArgumentException e) {
                OutputView.printIllegalArgumentException(e.getMessage());
            }
        }
    }

}
