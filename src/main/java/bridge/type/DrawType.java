package bridge.type;

import bridge.Draw;
import bridge.type.suppoter.DrawSupporter;

public enum DrawType implements DrawSupporter {

    PASS("O", true){
        @Override
        public void draw(PositionType position, boolean isPass, Draw draw) {
            if (PASS.isPass == isPass) {
                if (PositionType.isPosition(position)) {
                    draw.drawUpBridges(PASS.symbol);
                    return;
                }

                draw.drawDownBridges(PASS.symbol);
            }
        }
    },
    MISS("X", false) {
        @Override
        public void draw(PositionType position, boolean isPass, Draw draw) {
            if (MISS.isPass == isPass) {
                if (PositionType.isPosition(position)) {
                    draw.drawUpBridges(MISS.symbol);
                    return;
                }

                draw.drawDownBridges(MISS.symbol);
            }
        }
    };

    private final String symbol;
    private final boolean isPass;

    DrawType(String symbol, boolean isPass) {
        this.symbol = symbol;
        this.isPass = isPass;
    }
}
