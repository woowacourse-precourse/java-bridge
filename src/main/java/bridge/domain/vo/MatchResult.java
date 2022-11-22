package bridge.domain.vo;

import static bridge.common.message.MatchFormComponent.prefix;

import bridge.common.message.MatchFormComponent;
import java.util.List;

public class MatchResult {

    private StringBuilder upperSide;
    private StringBuilder downSide;


    public MatchResult() {
        this.upperSide = new StringBuilder();
        this.downSide = new StringBuilder();
    }

    public void reset() {
        upperSide.setLength(0);
        downSide.setLength(0);
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
        reset();
        appendPrefix();
        appendMiddleAreaOfMatchers(userInput);
        matchIsTrueAndLastInputIsCapitalU(userInput, match);
        matchIsTrueAndLastInputIsCapitalD(userInput, match);
        matchIsFalseAndLastInputIsCapitalU(userInput, match);
        matchIsFalseAndLastInputIsCapitalD(userInput, match);
        appendPostfix();
    }

    private void appendPostfix() {
        upperSide.append(MatchFormComponent.postfix);
        downSide.append(MatchFormComponent.postfix);
    }

    private void matchIsFalseAndLastInputIsCapitalD(List<String> userInput, boolean match) {
        if (match == false && userInput.get(userInput.size() - 1).equals("D")) {
            upperSide.append(MatchFormComponent.space);
            downSide.append(MatchFormComponent.WrongAnswer);
        }
    }

    private void matchIsFalseAndLastInputIsCapitalU(List<String> userInput, boolean match) {
        if (match == false && userInput.get(userInput.size() - 1).equals("U")) {
            upperSide.append(MatchFormComponent.WrongAnswer);
            downSide.append(MatchFormComponent.space);
        }
    }

    private void matchIsTrueAndLastInputIsCapitalD(List<String> userInput, boolean match) {
        if (match == true && userInput.get(userInput.size() - 1).equals("D")) {
            upperSide.append(MatchFormComponent.space);
            downSide.append(MatchFormComponent.CorrectAnswer);
        }
    }

    private void matchIsTrueAndLastInputIsCapitalU(List<String> userInput, boolean match) {
        if (match == true && userInput.get(userInput.size() - 1).equals("U")) {
            upperSide.append(MatchFormComponent.CorrectAnswer);
            downSide.append(MatchFormComponent.space);
        }
    }

    private void appendMiddleAreaOfMatchers(List<String> userInput) {
        for (int index = 0; index < userInput.size()-1; index++) {
            matchIsCapitalU(userInput, index);
            matchIsCapitalD(userInput, index);
            appendSeparator();
        }
    }

    private void appendSeparator() {
        upperSide.append(MatchFormComponent.middleFormat);
        downSide.append(MatchFormComponent.middleFormat);
    }

    private void matchIsCapitalD(List<String> userInput, int index) {
        if (userInput.get(index).equals("D")) {
            upperSide.append(MatchFormComponent.space);
            downSide.append(MatchFormComponent.CorrectAnswer);
        }
    }

    private void matchIsCapitalU(List<String> userInput, int index) {
        if (userInput.get(index).equals("U")) {
            upperSide.append(MatchFormComponent.CorrectAnswer);
            downSide.append(MatchFormComponent.space);
        }
    }

    private void appendPrefix() {
        upperSide.append(prefix);
        downSide.append(prefix);
    }
}
