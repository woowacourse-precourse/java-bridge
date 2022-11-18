package bridge;

public class OutputView {

    public void printGameStart() {
        System.out.println(Output.gameStart.getOutput());
    }

    public void printBridgeLengthInputRequest() {
        System.out.println(Output.bridgeLengthInputRequest.getOutput());
    }

    public void printWhereToGoInputRequest() {
        System.out.println(Output.whereToGoInputRequest);
    }

    public void printContinueOrEndRequest() {
        System.out.println(Output.continueOrEndRequest.getOutput());
    }

    public void printResult(boolean isWin, int numberOfAttempt) {
        if (isWin) {
            System.out.println(Output.winOrLoseResult.getOutput()+"성공");
            return;
        }
        System.out.println(Output.howManyAttempts.getOutput()+"실패");
    }

}
