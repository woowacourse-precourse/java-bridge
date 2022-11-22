package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.SlabDTO;
import bridge.type.GlassType;
import bridge.type.PositionType;
import bridge.util.Console;

import java.util.List;

public class ReadyController extends Controller {
    private final BridgeMaker bridgeMaker = BridgeMaker.getInstance();

    public ReadyController() {
        super();
    }

    public void printGameIntroduce() {
        this.getTitleMessage();
        this.getIntroduceHeader();
        this.getIntroduceBody();
    }

    private void getTitleMessage() {
        Console.printLine("┏━━━━━━━━━━━┓");
        Console.printLine("   다리 건너기");
        Console.printLine("┗━━━━━━━━━━━┛");
        Console.printLine("우아한테크코스 5기 프리코스 4주차 미션");
        Console.printLine("만든이: 윤창욱 (Laeng)");
        Console.printLine("");
    }

    private void getIntroduceHeader() {
        Console.printLine("┏━━━━━━━━━━━┓");
        Console.printLine("   게임 소개 ");
        Console.printLine("┗━━━━━━━━━━━┛");
    }

    private void getIntroduceBody() {
        Console.printLine("다리를 무사히 건너세요.");
        Console.printLine("여러분이 입력한 크기의 다리를 건너면 성공이에요.");
        Console.printLine("");
        Console.printLine("다리 건너기 게임을 시작합니다.");
        Console.printLine("");
    }

    public int askBridgeSize() {
        return this.inputView.readBridgeSize();
    }

    public void buildBridge(int size) {
        List<String> bridge = this.bridgeMaker.makeBridge(size);

        for (int index = 0; index < size; index++) {
            List<SlabDTO> slabs = this.convertToSlabs(index, bridge.get(index));
            this.slabs.insertAll(slabs);
        }
    }

    private List<SlabDTO> convertToSlabs(int step, String safePosition) {
        PositionType position = PositionType.build(safePosition);

        return List.of(
                new SlabDTO(step, position, GlassType.TEMPERED),
                new SlabDTO(step, PositionType.build(position.getId() ^ 1), GlassType.NORMAL)
        );
    }
}
