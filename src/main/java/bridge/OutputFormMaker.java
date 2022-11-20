package bridge;

import java.util.ArrayList;
import java.util.List;

public class OutputFormMaker {

    public OutputFormMaker() {
    }

    public List<String> createFirstLineList(List<String> user, List<String> bridge) {
        List<String> firstLine = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).equals("U")) {
                firstLine.add(Boolean.toString(user.get(i).equals(bridge.get(i))));
                continue;
            }
            firstLine.add(" ");
        }
        return firstLine;
    }

    public List<String> createSecondLineList(List<String> user, List<String> bridge) {
        List<String> secondLine = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).equals("D")) {
                secondLine.add(Boolean.toString(user.get(i).equals(bridge.get(i))));
                continue;
            }
            secondLine.add(" ");
        }
        return secondLine;
    }

    public String createMapForm(List<String> lineList) {
        String line = String.join(" | ", lineList)
                .replace("true", "O")
                .replace("false", "X");
        line = "[ " + line + " ]";
        return line;
    }

    public String createResult(List<String> user, List<String> bridge) {
        if (user.equals(bridge)) {
            return "성공";
        }
        return "실패";
    }
}