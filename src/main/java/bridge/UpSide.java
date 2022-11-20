package bridge;

import java.util.ArrayList;
import java.util.List;

public class UpSide {
    private String upSide;
    public List<String> upSideArr = new ArrayList<>();

    public String makeUpSide() {
        String upSideString = String.join(" | ", upSideArr);
        upSide = "[ ";
        upSide += upSideString;
        upSide += " ]";
        return upSide;
    }

    public String getUpSide(){
        return upSide;
    }
}
