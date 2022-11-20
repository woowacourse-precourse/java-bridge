package bridge.domain;

import static bridge.Constant.BOUNDARY_BETWEEN_FOOTPRINT;
import static bridge.Constant.BRIDGE_LEFT_BOUNDARY;
import static bridge.Constant.BRIDGE_RIGHT_BOUNDARY;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum FootPrintStatus {
    NOT_BROKEN(" O "), NOT_PASS("   "), BROKEN(" X ");

    private String shape;

    FootPrintStatus(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}

public class FootPrint {
    private List<FootPrintStatus> footPrintFromTop;
    private List<FootPrintStatus> footPrintFromBot;

    public FootPrint() {
        footPrintFromTop = new ArrayList<>();
        footPrintFromBot = new ArrayList<>();
    }

    public Integer getOrder() {
        return footPrintFromTop.size();
    }

    public void record(FootrestLocation footrestLocation, Boolean isSafe) {
        if (footrestLocation == FootrestLocation.UP) {
            recordMovedStatus(footPrintFromTop, isSafe);
            recordNotStepped(footPrintFromBot);
            return;
        }
        recordMovedStatus(footPrintFromBot, isSafe);
        recordNotStepped(footPrintFromTop);
    }

    private void recordNotStepped(List<FootPrintStatus> footPrint) {
        footPrint.add(FootPrintStatus.NOT_PASS);
    }

    private void recordMovedStatus(List<FootPrintStatus> footPrint, Boolean isSafe) {
        if (isSafe) {
            footPrint.add(FootPrintStatus.NOT_BROKEN);
            return;
        }
        footPrint.add(FootPrintStatus.BROKEN);
        return;
    }


    @Override
    public String toString() {
        String result = "";
        result += wrapBoundary(footPrintFromTop.stream().map(x -> x.getShape()).collect(Collectors.toList())) + "\n";
        result += wrapBoundary(footPrintFromBot.stream().map(x -> x.getShape()).collect(Collectors.toList()));
        return result;
    }

    private String wrapBoundary(List<String> footPrint) {
        return BRIDGE_LEFT_BOUNDARY + String.join(BOUNDARY_BETWEEN_FOOTPRINT, footPrint) + BRIDGE_RIGHT_BOUNDARY;
    }
}
