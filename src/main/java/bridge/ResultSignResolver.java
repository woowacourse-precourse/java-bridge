package bridge;

import bridge.view.sign.SignStrategy;

import java.util.List;

import static bridge.support.ResultSign.*;

public class ResultSignResolver {

    private final Result result;
    private final SignStrategy strategy;
    private StringBuilder sb;

    public ResultSignResolver(Result result, SignStrategy strategy) {
        this.result = result;
        this.strategy = strategy;
        this.sb = new StringBuilder();
    }

    public String resolveResult() {
        List<Boolean> isAnswers = result.getIsAnswers();
        List<MoveDirection> directions = result.getDirections();

        for (int i = 0; i < isAnswers.size(); i++) {
            strategy.appendSignIsDownSignAnswer(isAnswers.get(i), directions.get(i));
            strategy.appendSignIsDownSignWrongAnswer(isAnswers.get(i), directions.get(i));
            strategy.appendSignIsUpSignAnswer(isAnswers.get(i), directions.get(i));
            strategy.appendSignIsUpSignWrongAnswer(isAnswers.get(i), directions.get(i));
            strategy.appendSeparatorIsNotLast(i, isAnswers.size());
        }
        return sb.toString();
    }
}
