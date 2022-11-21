package bridge.domain;

import bridge.exception.Validator;

public class Round {

    private final String movingExpression;
    private RoundResult roundResult;

    public Round(String movingExpression) {
        Validator.validMoving(movingExpression);
        this.movingExpression = movingExpression;
    }
}
