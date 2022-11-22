package bridge;

public enum MapSkeleton {
    U(" O ", "   ", "   ", " X "),
    D("   ", " O ", " X ", "   ");

    private final String firstRight;
    private final String secondRight;
    private final String firstWrong;
    private final String secondWrong;

    MapSkeleton(String firstRight, String secondRight, String firstWrong, String secondWrong) {
        this.firstRight = firstRight;
        this.secondRight = secondRight;
        this.firstWrong = firstWrong;
        this.secondWrong = secondWrong;
    }

    public String getFirst(boolean stepStatus) {
        if (stepStatus) return this.firstRight;
        return this.firstWrong;
    }

    public String getSecond(boolean stepStatus) {
        if (stepStatus) return this.secondRight;
        return this.secondWrong;
    }
}
