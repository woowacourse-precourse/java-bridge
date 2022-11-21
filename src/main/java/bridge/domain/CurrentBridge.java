package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.Constant.*;

public class CurrentBridge {
    private List<String> currentShape;
    private final List<String> upperSection;
    private final List<String> lowerSection;

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
        }
        secondSection.add(WHITE_SPACE);
    }

    private boolean isSectionCanCross(String readMoving) {
        return currentShape.get(currentShape.size() - 1).equals(readMoving);
    }

    public boolean isSuccessLastSection() {
        boolean isUpperSuccess = upperSection.get(upperSection.size() - 1).equals(OK);
        boolean isLowerSuccess = lowerSection.get(lowerSection.size() - 1).equals(OK);
        return isUpperSuccess || isLowerSuccess;
    }

    public List<String> getUpperSection() {
        return upperSection;
    }

    public List<String> getLowerSection() {
        return lowerSection;
    }
}
