package bridge;

import java.util.List;

public class OutputView {

    public void printGameStart() {
        System.out.println(Output.gameStart.getOutput());
    }

    public void printBridgeLengthInputRequest() {
        System.out.println(Output.bridgeLengthInputRequest.getOutput());
    }

    public void printWhereToGoInputRequest() {
        System.out.println(Output.whereToGoInputRequest.getOutput());
    }

    public void printMap(List<String> mapUpper, List<String> mapLower) {
        mapUpper.stream()
                .forEach(System.out::print);
        System.out.println();
        mapLower.stream()
                .forEach(System.out::print);
        System.out.println();
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
