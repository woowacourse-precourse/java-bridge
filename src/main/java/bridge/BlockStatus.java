package bridge;

public enum BlockStatus {
    SUCCESS, FAIL, NOT_VISITED;

    public boolean isPassed() {
        return this == SUCCESS;
    }

    public boolean isVisited() {
        return this != NOT_VISITED;
    }
}
