package bridge.domain;

import static bridge.Constant.BOUNDARY_BETWEEN_FOOTPRINT;
import static bridge.Constant.BRIDGE_LEFT_BOUNDARY;
import static bridge.Constant.BRIDGE_RIGHT_BOUNDARY;
import static bridge.Constant.BROKEN_FOOTPRINT;
import static bridge.Constant.NOT_BROKEN_FOOTPRINT;
import static bridge.Constant.NOT_PASS_FOOTPRINT;

import java.util.ArrayList;
import java.util.List;

public class FootPrint {
    private List<FootrestLocation> footPrint;
    private Boolean failAtLast;

    public FootPrint() {
        footPrint = new ArrayList<>();
        failAtLast = false;
    }

    public Integer getOrder() {
        return footPrint.size();
    }

    public void record(FootrestLocation footrestLocation) {
        footPrint.add(footrestLocation);
    }

    // TODO 여기 로직이 단순해지려면 FootPrint 객체에서 움직인 위치 + 성공여부를 담으면 됨. 뭐가 더 알맞을지 고민해보기
    //  그리고 OutputView에서 모양새를 만들어주는게 맞을까, toString이 맞을까.
    @Override
    public String toString() {
        String result = "";
        List<String> footPrintFromTop = new ArrayList<>();
        List<String> footPrintFromBot = new ArrayList<>();
        for (FootrestLocation each : footPrint) {
            if (each == FootrestLocation.UP) {
                footPrintFromTop.add(NOT_BROKEN_FOOTPRINT);
                footPrintFromBot.add(NOT_PASS_FOOTPRINT);
            } else {
                footPrintFromTop.add(NOT_PASS_FOOTPRINT);
                footPrintFromBot.add(NOT_BROKEN_FOOTPRINT);
            }
        }
        if (failAtLast) {
            if (footPrint.get(footPrint.size() - 1) == FootrestLocation.UP) {
                footPrintFromTop.set(footPrint.size() - 1, BROKEN_FOOTPRINT);
            } else {
                footPrintFromBot.set(footPrint.size() - 1, BROKEN_FOOTPRINT);
            }
        }
        result += BRIDGE_LEFT_BOUNDARY + String.join(BOUNDARY_BETWEEN_FOOTPRINT, footPrintFromTop) + BRIDGE_RIGHT_BOUNDARY+ "\n";
        result += BRIDGE_LEFT_BOUNDARY + String.join(BOUNDARY_BETWEEN_FOOTPRINT, footPrintFromBot) + BRIDGE_RIGHT_BOUNDARY;
        return result;
    }

    public void failAtLast() {
        this.failAtLast = true;
    }
}
