package bridge.view;

public class OutputView {

    public void printMap(String output) {
        System.out.println(output);
    }

    public void printResult(String output) {
        System.out.println(output);
    }

    public void printErrorMessage(final Exception e) {
        System.out.println("[ERROR] : " + e.getMessage());
    }

    public void printResultMessage(String output) {
        System.out.println(Sentence.FINAL_RESULT.getValue() + output + "\n");
    }

    public void printSuccessOrFailMessage(String output) {
        System.out.println(Sentence.GAME_SUCCESS_OR_FAIL.getValue() + output);
    }

    public void printTotalTrial(String output) {
        System.out.println(Sentence.TOTAL_TRIAL.getValue() + output);
    }
}
