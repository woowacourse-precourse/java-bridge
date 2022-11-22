package bridge.domain.resources;

public class ReOrQuit {

    public final static String RE_GAME = "R";
    public final static String QUIT_GAME = "Q";

    private final String inputRQ;

    private ReOrQuit(String inputRQ) {
        this.inputRQ = inputRQ;
    }

    public static ReOrQuit of(String inputRQ) {
        validateRorQ(inputRQ);
        return new ReOrQuit(inputRQ);
    }

    private static void validateRorQ(String inputRQ) {
        if (isInputRQ(inputRQ)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInputRQ(String inputRQ) {
        return !inputRQ.equals(RE_GAME) && !inputRQ.equals(QUIT_GAME);
    }

    public String getInputRQ() {
        return inputRQ;
    }
}
