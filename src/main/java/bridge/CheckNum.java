package bridge;
public class CheckNum {
    public CheckNum() {
    }

    public void checkVoidOrSpace(String _input) {
        if (_input.equals(" ") || _input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstant.OCCUR_STRING.getMessage());
        }
    }
    public void checkString(String _input) {
        try {
            Double.parseDouble(_input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.OCCUR_STRING.getMessage());
        }
    }

    public void checkNegative(int _input) {
        if (_input < 0) {
            throw new IllegalArgumentException(ErrorMessageConstant.OCCUR_NEGATIVE.getMessage());
        }
    }

    public void checkRange(int _input) {
        if (_input < Constant.RANGE_START.getConstant() || _input > Constant.RANGE_END.getConstant()) {
            throw new IllegalArgumentException(ErrorMessageConstant.OCCUR_OUT_RANGE.getMessage());
        }
    }

    public void checkInputSize(String _input) {
        if (_input.length() > 1) {
            throw new IllegalArgumentException(ErrorMessageConstant.OCCUR_OUT_STRING.getMessage());
        }

    }
    public void checkUpOrDownInputRange(String _input) {
        if ((int) _input.charAt(0) != Constant.UP_CONTROL_ASCII.getConstant()
                && (int) _input.charAt(0) != Constant.DOWN_CONTROL_ASCII.getConstant()) {
            throw new IllegalArgumentException(ErrorMessageConstant.OCCUR_NOT_SPECIFIED_UpOrDown.getMessage());
        }
    }

    public void checkRestartInputRange(String _input) {
        if ((int) _input.charAt(0) != Constant.RESTART_CONTROL_ASCII.getConstant()
                && (int) _input.charAt(0) != Constant.STOP_CONTROL_ASCII.getConstant()) {
            throw new IllegalArgumentException(ErrorMessageConstant.OCCUR_NOT_SPECIFIED_RestartOrStop.getMessage());
        }
    }
}
