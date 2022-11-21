package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    private String getElement(int index) {
        return bridge.get(index);
    }

    /**
     * 도메인 로직
     */
    public boolean isCorrectLastElement(Bridge answer) {
        int lastIndex = this.getSize() - 1;

        String userAnswer = this.getElement(lastIndex);
        String expected = answer.getElement(lastIndex);

        return expected.equals(userAnswer);
    }

    public void moveNext(String moving) {
        this.bridge.add(moving);
    }

    public List<String> matchAnswer(Bridge answer) {
        return IntStream.range(0, getSize())
                .mapToObj(o -> isCorrect(answer.getElement(o), this.getElement(o)))
                .collect(Collectors.toList());
    }

    private String isCorrect(String answer, String input) {
        if (answer.equals(input))
            return "O";

        return "X";
    }
}
