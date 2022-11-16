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

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printResult(String winOrLose, int numberOfAttempt) {
        System.out.println(Output.winOrLoseResult.getOutput()+winOrLose);
        System.out.println(Output.howManyAttempts.getOutput()+numberOfAttempt);
    }

}
