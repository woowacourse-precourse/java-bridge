package bridge.domain;

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
                footPrintFromTop.add(" O ");
                footPrintFromBot.add("   ");
            } else {
                footPrintFromTop.add("   ");
                footPrintFromBot.add(" O ");
            }
        }
        if (failAtLast) {
            if (footPrint.get(footPrint.size() - 1) == FootrestLocation.UP) {
                footPrintFromTop.set(footPrint.size() - 1, " X ");
            } else {
                footPrintFromBot.set(footPrint.size() - 1, " X ");
            }
        }
        result += "[" + String.join("|", footPrintFromTop) + "]\n";
        result += "[" + String.join("|", footPrintFromBot) + "]";
        return result;
    }

    public void failAtLast() {
        this.failAtLast = true;
    }
}
