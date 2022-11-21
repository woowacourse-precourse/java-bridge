package bridge.domain;

public class BridgeGameResult {

    private final EachSideResult upSide;
    private final EachSideResult downSide;

    public BridgeGameResult() {
        this.upSide = new EachSideResult();
        this.downSide = new EachSideResult();
    }

    public void append(BridgeMatchResult bridgeMatchResult) {
        String upSideMark = bridgeMatchResult.getUpMark();
        String downSideMark = bridgeMatchResult.getDownMark();

        upSide.append(upSideMark);
        downSide.append(downSideMark);
    }

    @Override
    public String toString() {
        return String.valueOf(upSide) + downSide;
    }
}
