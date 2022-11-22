package bridge.view;

public class OutputView {

    public void printMap(final String output) {
        System.out.println(output + "\n");
    }

    public void printResult(final String output) {
        System.out.println(output);
    }

    public void printErrorMessage(final Exception e) {
        System.out.println("[ERROR] : " + e.getMessage());
    }

    public void printResultMessage(final String output) {
        System.out.println(Sentence.FINAL_RESULT.getValue() + output + "\n");
    }

    public void printSuccessOrFailMessage(final String output) {
        System.out.println(Sentence.GAME_SUCCESS_OR_FAIL.getValue() + output);
    }

    public void printTotalTrial(final String output) {
        System.out.println(Sentence.TOTAL_TRIAL.getValue() + output);
    }
}
