package bridge;

import java.util.ArrayList;
import java.util.List;

public class UpSide {
    private String upSide;

    public String makeUpSide(List<String> bridge) {
        String upSideString = String.join("|", convertUpSide(bridge));
        upSide += "[ ";
        upSide += upSideString;
        upSide += " ]";
        System.out.println(upSide);
        return upSide;
    }

    public List<String> convertUpSide(List<String> bridge) {
        List<String> upSideArr = new ArrayList<>();
        for (String e : bridge) {
            if (e.equals("U"))
                upSideArr.add("O");
            if (e.equals("D"))
                upSideArr.add(" ");
        }
        return upSideArr;
    }
}
