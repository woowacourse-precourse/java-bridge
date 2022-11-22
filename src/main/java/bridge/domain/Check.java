package bridge.domain;

public class Check {

    private static final String CORRECT_SIGN = "O";
    private static final String INCORRECT_SIGN = "X";
    private String guess;
    private String result;

    private Check(String guess, String result) {
        this.guess = guess;
        this.result = result;
    }

    public String getGuess() {
        return guess;
    }

    public String getResult() {
        return result;
    }

    public static Check getGuessResult(String answer, String guess) {
        String sign = INCORRECT_SIGN;

        if (answer.equals(guess)) {
            sign = CORRECT_SIGN;
        }

        return new Check(guess, sign);
    }

    @Override
    public String toString() {
        return "{" +
                "guess='" + guess + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
