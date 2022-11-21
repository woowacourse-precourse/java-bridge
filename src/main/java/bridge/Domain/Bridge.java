package bridge.Domain;

import static bridge.Utils.Constant.MatchResult.CORRECT;
import static bridge.Utils.Constant.MatchResult.INCORRECT;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> answer;
    private List<String> user;
    private BridgeMap result;

    public Bridge(List<String> answer) {
        this.answer = new ArrayList<>(answer);
        this.user = new ArrayList<>();
        this.result = new BridgeMap();
    }

    public void addMoving(String oneStep) {
        user.add(oneStep);
    }

    public boolean isMatchAboutLastMoving() {
        int index = user.size() - 1;
        String answerMoving = answer.get(index);
        String myMoving = user.get(index);
        return matching(myMoving, answerMoving);
    }

    private boolean matching(String myMoving, String answerMoving) {
        if (myMoving.equals(answerMoving)) {
            result.add(myMoving, CORRECT.toString());
            return true;
        }
        result.add(myMoving, INCORRECT.toString());
        return false;
    }

    public String getResult() {
         return result.toString();
    }

    public boolean isFinish() {
        if(user.size() == answer.size()) {
            return true;
        }
        return false;
    }

    public void clear() {
        user.clear();
        result.clear();
    }
}
