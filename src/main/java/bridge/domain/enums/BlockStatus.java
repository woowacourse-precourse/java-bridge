package bridge.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BlockStatus {
    UP(1, "U"),
    DOWN(0, "D");

    private final int crossableNumber;
    private final String crossableSymbol;

    BlockStatus(final int crossableNumber, final String crossableSymbol) {
        this.crossableNumber = crossableNumber;
        this.crossableSymbol = crossableSymbol;
    }

    public static List<BlockStatus> convertToBlockStatues(List<String> symbolBlocks) {
        return symbolBlocks.stream()
                .map(BlockStatus::findByCrossableSymbol)
                .collect(Collectors.toList());
    }

    private static BlockStatus findByCrossableSymbol(final String symbolBlock) {
        return Arrays.stream(BlockStatus.values())
                .filter(blockStatus -> blockStatus.hasCrossableSymbol(symbolBlock))
                .findFirst()
                .get();
    }

    private boolean hasCrossableSymbol(final String symbolBlock) {
        return this.crossableSymbol
                .equals(symbolBlock);
    }

    public static List<String> createSymbolBlocks(List<Integer> numberBlocks) {
        return numberBlocks.stream()
                .map(BlockStatus::getCrossableSymbol)
                .collect(Collectors.toList());
    }

    private static String getCrossableSymbol(final int crossableNumber) {
        return Arrays.stream(BlockStatus.values())
                .filter(blockStatus -> blockStatus.hasCrossableNumber(crossableNumber))
                .findFirst()
                .orElseThrow()
                .crossableSymbol;
    }

    private boolean hasCrossableNumber(final int crossableNumber) {
        return this.crossableNumber == crossableNumber;
    }


}
