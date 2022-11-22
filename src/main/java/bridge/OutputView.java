package bridge;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.BlockPosition.D;
import static bridge.BlockPosition.U;

public class OutputView {
    private static final String BRIDGE_FORMAT = "[%s]\n[%s]";
    private static final String PASS = " O ";
    private static final String FAIL = " X ";
    private static final String EMPTY = "   ";
    private static final String BAR = "|";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(List<Block> blocks) {
        String up = blocks.stream()
                .map(this::up)
                .collect(Collectors.joining(BAR));

        String down = blocks.stream()
                .map(this::down)
                .collect(Collectors.joining(BAR));

        System.out.printf((BRIDGE_FORMAT) + "%n", up, down);
    }

    public void printResult(List<Block> blocks, boolean arrived, int count) {
        System.out.println("\n최종 게임 결과");
        printMap(blocks);
        System.out.printf(("\n게임 성공 여부: %s") + "%n", resultMessage(arrived));
        System.out.printf(("총 시도한 횟수: %d") + "%n", count);
    }

    private String up(Block block) {
        if (block.position() == U && block.isPassed()) {
            return PASS;
        }
        if (block.position() == D && !block.isPassed()) {
            return FAIL;
        }
        return EMPTY;
    }

    private String down(Block block) {
        if (block.position() == D && block.isPassed()) {
            return PASS;
        }
        if (block.position() == U && !block.isPassed()) {
            return FAIL;
        }
        return EMPTY;
    }

    private String resultMessage(boolean arrived) {
        if (arrived) {
            return SUCCESS_MESSAGE;
        }
        return FAIL_MESSAGE;
    }
}
