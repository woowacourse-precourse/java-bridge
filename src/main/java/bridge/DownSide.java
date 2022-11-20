package bridge;

import java.util.ArrayList;
import java.util.List;

public class DownSide {
    private String downSide;

    public String makeDownSide(List<String> bridge) {
        String downSideString = String.join(" | ", convertDownSide(bridge));
        downSide += "[ ";
        downSide += downSideString;
        downSide += " ]";
        System.out.println(downSide);
        return downSide;
    }

    public List<String> convertDownSide(List<String> bridge) {
        List<String> downSideArr = new ArrayList<>();
        for (String e : bridge) {
            if (e.equals("U"))
                downSideArr.add(" ");
            if (e.equals("D"))
                downSideArr.add("O");
        }
        return downSideArr;
    }
}
