package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.Constant.*;

public class CurrentBridge {
    private List<String> currentShape;
    private final List<String> upperSection;
    private final List<String> lowerSection;
    private boolean isFailed = false;

    public CurrentBridge() {
        this.currentShape = new ArrayList<>();
        this.lowerSection = new ArrayList<>();
        this.upperSection = new ArrayList<>();
    }

    public void setSection(List<String> currentShape, String readMoving) {
        this.currentShape = currentShape;
        if (readMoving.equals(UP)) {
            setUpperSectionLast(readMoving);
        }
        if (readMoving.equals(DOWN)) {
            setLowerSectionLast(readMoving);
        }
    }

    private void setUpperSectionLast(String readMoving) {
        setLastSection(readMoving, upperSection, lowerSection);
    }

    private void setLowerSectionLast(String readMoving) {
        setLastSection(readMoving, lowerSection, upperSection);
    }

    private void setLastSection(String readMoving, List<String> firstSection, List<String> secondSection) {
        boolean sectionCanCross = isSectionCanCross(readMoving);
        if (sectionCanCross) {
            firstSection.add(OK);
        }
        if (!sectionCanCross) {
            firstSection.add(X);
            isFailed = true;
        }
        secondSection.add(WHITE_SPACE);
    }

    private boolean isSectionCanCross(String readMoving) {
        return currentShape.get(currentShape.size() - 1).equals(readMoving);
    }

    public List<String> getUpperSection() {
        return upperSection;
    }

    public List<String> getLowerSection() {
        return lowerSection;
    }

    public boolean isFailed() {
        return isFailed;
    }

    public int getCurrentBridgeLength() {
        return currentShape.size();
    }
}
