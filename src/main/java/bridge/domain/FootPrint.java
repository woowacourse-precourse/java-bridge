package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class FootPrint {
    private List<FootrestLocation> footPrint;

    public FootPrint() {
        footPrint = new ArrayList<>();
    }

    public Integer getOrder() {
        return footPrint.size();
    }

    public void record(FootrestLocation footrestLocation) {
        footPrint.add(footrestLocation);
    }

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
        result += "[" + String.join("|", footPrintFromTop) + "]\n";
        result += "[" + String.join("|", footPrintFromBot) + "]";
        return result;
    }
}
