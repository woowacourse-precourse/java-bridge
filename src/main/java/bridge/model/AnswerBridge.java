package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class AnswerBridge {

    List<String> answerBridge;

    public AnswerBridge(final List<String> bridge) {
        this.answerBridge = bridge;
    }

    // TODO: 이제 중간에 실패할 경우, 재시작 여부를 묻고, 그에 따라 게임을 재시작하거나 끝내는 기능 만들면 됨

    public List<Boolean> compareTo(User user) {
        List<String> userBridge = user.getChoices();
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < userBridge.size(); i++) {
            if (isSame(answerBridge.get(i), userBridge.get(i))) {
                result.add(true);
                continue;
            }
            result.add(false);
        }
        return result;
    }

    private boolean isSame(String answerBridgeWord, String userBridgeWord) {
        return answerBridgeWord.equals(userBridgeWord);
    }

    public boolean isCorrect(String choice, int step) {
        String answer = answerBridge.get(step);
        return answer.equals(choice);
    }

}
