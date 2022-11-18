package bridge.domain.vo;

import java.util.List;

public class MatchResult {

    private StringBuilder upperSide;
    private StringBuilder downSide;


    public MatchResult() {
        this.upperSide = new StringBuilder();
        this.downSide = new StringBuilder();
    }

    public void correctUpperSide(boolean moveOrNot, List<String> userInputs) {

    }

    public void retry() {
        upperSide.delete(0, upperSide.length());
        downSide.delete(0, downSide.length());
    }

    private void printUpperSide() {
        System.out.println(upperSide.toString());
    }

    private void printDownSide() {
        System.out.println(downSide.toString());
    }

    public void printUpAndDownSides() {
        printUpperSide();
        printDownSide();
    }


    public void matchProcess(List<String> userInput, boolean match) {
        for (int i = 0; i < userInput.size(); i++) {

        }
    }
}
