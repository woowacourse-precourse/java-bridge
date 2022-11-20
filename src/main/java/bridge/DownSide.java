package bridge;

import java.util.ArrayList;
import java.util.List;

public class DownSide {
    private String downSide;
    public List<String> downSideArr;

    public DownSide() {
        this.downSide = makeDownSide();
    }

    public String makeDownSide() {
        downSideArr = new ArrayList<>();
        convertDownSide();
        String downSideString = String.join(" | ", downSideArr);
        downSide = "[ ";
        downSide += downSideString;
        downSide += " ]";
        return downSide;
    }

    public void convertDownSide() {
        for (String e : Application.movingInputs) {
            if (e.equals("U"))
                downSideArr.add("O");
            if (e.equals("D"))
                downSideArr.add(" ");
            if (e.equals("X"))
                downSideArr.add("X");
        }
    }

    public String getDownSide() {
        return this.downSide;
    }
}
