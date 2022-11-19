package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.constant.Constant.*;

public class CurrentBridge {
    private final List<String> currentShape;
    private final List<String> upperSection;
    private final List<String> lowerSection;
    private boolean isFailed = false;

    public CurrentBridge(List<String> currentShape, String readMoving) {
        this.currentShape = currentShape;
        this.upperSection = setSection(UP);
        this.lowerSection = setSection(DOWN);
        if (readMoving.equals(UP)) {
            setUpperSectionLast(readMoving);
        }
        if (readMoving.equals(DOWN)) {
            setLowerSectionLast(readMoving);
        }
    }

    private List<String> setSection(String section) {
        return currentShape.stream()
                .map(zone -> {
                    if (zone.equals(section)) {
                        return section;
                    }
                    return WHITE_SPACE;
                })
                .collect(Collectors.toList());
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
            firstSection.set(firstSection.size() - 1, OK);
        }
        if (!sectionCanCross) {
            firstSection.set(firstSection.size() - 1, X);
            isFailed = true;
        }
        secondSection.set(secondSection.size() - 1, WHITE_SPACE);
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
