package bridge.domain.vo;

public class MatchResult {

    private StringBuilder upperSide;
    private StringBuilder downSide;


    public MatchResult() {
        this.upperSide = new StringBuilder();
        this.downSide = new StringBuilder();
    }

    public void correctUpperSide(int position) {
        upperSide.
    }

    public void retry() {
        upperSide.delete(0, upperSide.length());
        downSide.delete(0, downSide.length());
    }

    public void printUpperSide() {
        System.out.println(upperSide.toString());
    }

    public void printDownSide() {
        System.out.println(downSide.toString());
    }
}
