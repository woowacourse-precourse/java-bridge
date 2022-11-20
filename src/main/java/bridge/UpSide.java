package bridge;

import java.util.ArrayList;
import java.util.List;

public class UpSide {
    private String upSide;
    public List<String> upSideArr;

    public UpSide() {
        this.upSide = makeUpSide();
    }

    public String makeUpSide() {
        upSideArr = new ArrayList<>();
        convertUpSide();
        String upSideString = String.join(" | ", upSideArr);
        upSide = "[ ";
        upSide += upSideString;
        upSide += " ]";
        return upSide;
    }

    public void convertUpSide() {
        for (String e : Application.movingInputs) {
            if (e.equals("U"))
                upSideArr.add("O");
            if (e.equals("D"))
                upSideArr.add(" ");
            if (e.equals("X"))
                upSideArr.add("X");
        }
    }

    public String getUpSide() {
        return this.upSide;
    }
}
