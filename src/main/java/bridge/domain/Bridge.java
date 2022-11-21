package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final int size;

    public Bridge(List<String> bridge, int size) {
        this.bridge = bridge;
        this.size = size;
    }

    public Bridge(int size) {
        this.size = size;
        this.bridge = new ArrayList<>();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getSize() {
        return size;
    }

    /**
     * 도메인 로직
     */
    public boolean isCorrectLastElement(Bridge answer, int stage) {
        String userLastInput = bridge.get(stage - 1);
        String expected = answer.getBridge().get(stage - 1);

        return expected.equals(userLastInput);
    }

    public void moveNext(String moving, int stage) {
        this.bridge.add(stage, moving);
    }

    public List<String> matchAnswer(Bridge user, int stage) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < stage; i++)
            answer.add(" ");

        while(stage-->0){
            String result = isCorrect(this.bridge.get(stage), user.bridge.get(stage));
            answer.set(stage, result);
        }

        return answer;
    }

    private String isCorrect(String answer, String input) {
        if(answer.equals(input))
            return "O";

        return "X";
    }
}
