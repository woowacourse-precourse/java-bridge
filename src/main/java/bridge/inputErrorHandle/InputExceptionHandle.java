package bridge.inputErrorHandle;

public class InputExceptionHandle {

    public void checkNumberFormat(String input) {
        try {
            int temp = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputException.COMMAND_LENGTH_EXCEPTION.getMessage());
        }
    }

    public void checkNumberRange(String input) {
        int size = Integer.parseInt(input);
        if (size < 3 || size > 20) throw new IllegalArgumentException(InputException.NUMBER_RANGE_EXCEPTION.getMessage());
    }

    public void checkCommandLength(String input){
        if(input.length() != 1) throw new IllegalArgumentException(InputException.COMMAND_LENGTH_EXCEPTION.getMessage());
    }

    public void checkCommandRange(String input){
        if(!input.equals("R") && !input.equals("Q")) throw new IllegalArgumentException(InputException.COMMAND_RANGE_EXCEPTION.getMessage());

    }
    public void checkDirectionLength(String input){
        if(input.length() != 1) throw new IllegalArgumentException(InputException.DIRECTION_LENGTH_EXCEPTION.getMessage());
    }

    public void checkDirectionRange(String input){
        if(!input.equals("U") && !input.equals("D")) throw new IllegalArgumentException(InputException.DIRECTION_RANGE_EXCEPTION.getMessage());
    }
}
