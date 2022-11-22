package bridge.model;

import static bridge.util.Constants.INITIAL_ATTEMPTS;

public class Result {
    private int attempts;
    private SuccessAndFail successAndFail;
    private Diagram diagram;

    private Result(int attempts, SuccessAndFail successAndFail, Diagram diagram) {
        this.attempts = attempts;
        this.successAndFail = successAndFail;
        this.diagram = diagram;
    }

    public static Result byDefault() {
        return new Result(INITIAL_ATTEMPTS, SuccessAndFail.FAIL, new Diagram());
    }

    public int getAttempts() {
        return attempts;
    }

    public void addAttempts() {
        attempts++;
    }

    public SuccessAndFail getSuccessOrFail() {
        return successAndFail;
    }

    public Diagram getDiagram() {
        return diagram;
    }

    public void setSuccess() {
        this.successAndFail = SuccessAndFail.SUCCESS;
    }

    public void updateDiagrams(Position position, SurviveAndDie surviveOrDie) {
        diagram.updateDiagrams(position, surviveOrDie);
    }

    public void initializeDiagrams() {
        diagram = new Diagram();
    }
}
