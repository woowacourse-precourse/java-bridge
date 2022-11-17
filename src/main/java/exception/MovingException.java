package exception;

public class MovingException {
    private String readMoving;

    public MovingException(String readMoving) {
        this.readMoving = readMoving;
        checkReadMoving(readMoving);
    }

    private void checkReadMoving(String readMoving) {
        if (!(readMoving.equals("U") || readMoving.equals("D"))) throw new IllegalArgumentException();
    }

    public String getReadMoving() {
        return readMoving;
    }
}
