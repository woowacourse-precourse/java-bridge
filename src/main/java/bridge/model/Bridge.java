package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    final List<String> answers;

    public Bridge(final List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getAnswersSize() {
        return answers.size();
    }

    public List<Boolean> compareTo(final List<String> choices) {
        List<Boolean> compareResults = new ArrayList<>();
        for (int index = 0; index < choices.size(); index++) {
            if (isSameWord(answers.get(index), choices.get(index))) {
                compareResults.add(true);
                continue;
            }
            compareResults.add(false);
        }
        return compareResults;
    }

    private boolean isSameWord(final String answer, final String choice) {
        return answer.equals(choice);
    }

}
