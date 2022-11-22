package bridge.domain;

public class BridgeGameResult {

    private final EachSideResult upSide;
    private final EachSideResult downSide;
    private int numberOfRetries;

    public BridgeGameResult() {
        upSide = new EachSideResult();
        downSide = new EachSideResult();
        numberOfRetries = 1;
    }

    public BridgeGameResult(int numberOfRetries) {
        upSide = new EachSideResult();
        downSide = new EachSideResult();
        this.numberOfRetries = numberOfRetries;
    }

    public void append(BridgeMatchResult bridgeMatchResult) {
        String upSideMark = bridgeMatchResult.getUpMark();
        String downSideMark = bridgeMatchResult.getDownMark();

        upSide.append(upSideMark);
        downSide.append(downSideMark);
    }

    public boolean isMissMatch() {
        return upSide.isMissMatch() || downSide.isMissMatch();
    }

    public int getNumberOfRetries() {
        return numberOfRetries;
    }

    public void setNumberOfRetries() {
        ++numberOfRetries;
    }

    @Override
    public String toString() {
        return String.valueOf(upSide) + downSide;
    }
}
