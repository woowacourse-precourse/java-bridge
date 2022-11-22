package bridge.UI.output;

import bridge.BridgeGame;
import bridge.enums.Direction;
import bridge.enums.MapStructure;

public class MapDrawer {
    private StringBuilder upSide;
    private StringBuilder downSide;

    public MapDrawer() {
        this.upSide = new StringBuilder();
        this.downSide = new StringBuilder();
    }

    public void initializeMap() {
        upSide = new StringBuilder();
        downSide = new StringBuilder();
    }

    public String drawMap(BridgeGame bridgeGame, int currentStage) {
        Direction direction = bridgeGame.getBridge().get(currentStage);

        if (currentStage == 1) {
            drawStageMapByPassOrNonPass(bridgeGame, direction);
            return wrapBrace();
        }
        addVerticalBar();
        drawStageMapByPassOrNonPass(bridgeGame, direction);
        return wrapBrace();
    }
    private void drawStageMapByPassOrNonPass(BridgeGame bridgeGame, Direction direction) {
        if (bridgeGame.isCurrentStageDirectionMatched()) {
            makePassMap(direction);
            return;
        }
        makeNonPassMap(direction);
    }
    private void makePassMap(Direction direction) {
        if (direction.isUp()) {
            addCorrectMark(upSide);
            addWhiteSpace(downSide);
        }
        if (direction.isDown()) {
            addWhiteSpace(upSide);
            addCorrectMark(downSide);
        }
    }

    private void makeNonPassMap(Direction direction) {
        if (direction.isUp()) {
            addWhiteSpace(upSide);
            addUnCorrectMark(downSide);
        }
        if (direction.isDown()) {
            addUnCorrectMark(upSide);
            addWhiteSpace(downSide);
        }
    }

    private String wrapBrace() {
        StringBuilder upSideClone = new StringBuilder(upSide);
        StringBuilder downSideClone = new StringBuilder(downSide);
        openMap(upSideClone, downSideClone);
        closeMap(upSideClone, downSideClone);
        return upSideClone.append("\n").append(downSideClone).toString();
    }

    private void openMap(StringBuilder upSide, StringBuilder downSide) {
        addOpenBrace(upSide);
        addOpenBrace(downSide);
    }

    private void closeMap(StringBuilder upSide, StringBuilder downSide) {
        addCloseBrace(upSide);
        addCloseBrace(downSide);
    }

    private void addOpenBrace(StringBuilder map) {
        map.insert(0, MapStructure.OPEN_BRACE.getPart());
    }

    private void addCloseBrace(StringBuilder map) {
        map.append(MapStructure.CLOSE_BRACE.getPart());
    }

    private void addVerticalBar() {
        upSide.append(MapStructure.VERTICAL_BAR.getPart());
        downSide.append(MapStructure.VERTICAL_BAR.getPart());
    }

    private void addCorrectMark(StringBuilder map) {
        map.append(MapStructure.CORRECT.getPart());
    }

    private void addUnCorrectMark(StringBuilder map) {
        map.append(MapStructure.INCORRECT.getPart());
    }

    private void addWhiteSpace(StringBuilder map) {
        map.append(MapStructure.WHITE_SPACE.getPart());
    }
}
