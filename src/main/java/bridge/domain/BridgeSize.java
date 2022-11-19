package bridge.domain;

public class BridgeSize {
    private int size;

    public BridgeSize(String s) {
        validate(s);
        this.size = size;
    }

    private void validate(String s) {
        isNumeric(s);
        isSizeInRange(s);
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            System.out.printf(Message.ERROR_SIZE_NOT_INTEGER.get());
            throw new IllegalArgumentException();
        }
    }

    private void isSizeInRange(String s) {
        int size = Integer.parseInt(s);
        if (size > 20 || size < 3) {
            System.out.printf(Message.ERROR_SIZE_OUT_OF_RANGE.get());
            throw new IllegalArgumentException();
        }
    }
}
