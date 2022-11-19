package bridge;

import java.util.List;

public class OutputView {

    public void printGameStart() {
        System.out.println(Output.GAME_START.getOutput());
    }

    public void printBridgeLengthInputRequest() {
        System.out.println(Output.BRIDGE_LENGTH_INPUT_REQUEST.getOutput());
    }

    public void printWhereToGoInputRequest() {
        System.out.println(Output.WHERE_TO_GO_INPUT_REQUEST.getOutput());
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
        System.out.println(Output.CONTINUE_OR_END_REQUEST.getOutput());
    }

    public void printTitle() {
        System.out.println(Output.GAME_RESULT_TITLE.getOutput());
    }

    public void printResult(Map map,boolean isWin, int numberOfAttempt) {
        printTitle();
        printMap(map.getMapUpper(),map.getMapLower());
        if (isWin) {
            System.out.println(Output.WIN_OR_LOSE.getOutput()+"성공");
            System.out.println(Output.HOW_MANY_ATTEMPTS.getOutput()+numberOfAttempt);
            return;
        }
        System.out.println(Output.HOW_MANY_ATTEMPTS.getOutput()+"실패");
        System.out.println(Output.HOW_MANY_ATTEMPTS.getOutput()+numberOfAttempt);
        return;
    }

}
