package com.fusion.coding;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;

@Getter
public class GridPosition {

    private static final Map<Character, Integer> GRID_COLUMN_TO_BOARD_INDEX = unmodifiableMap(new HashMap() {{
        put('a', 0);
        put('b', 1);
        put('c', 2);
        put('d', 3);
        put('e', 4);
        put('f', 5);
        put('g', 6);
        put('h', 7);
    }});

    private GridPosition(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public static GridPosition parse(String position) {
        if (StringUtils.isBlank(position) || position.length() > 2) {
            throw new IllegalArgumentException("Illegal position: " + position);
        }
        return new GridPosition(toColumnIndex(position.charAt(0)), toRowIndex(position.charAt(1)));
    }

    private static int toColumnIndex(char c) {
        if (!GRID_COLUMN_TO_BOARD_INDEX.containsKey(c)) {
            throw new IllegalArgumentException("Illegal column: " + c);
        }
        return GRID_COLUMN_TO_BOARD_INDEX.get(c);
    }

    private static int toRowIndex(char c) {
        int rowIndex = Integer.parseInt(String.valueOf(c)) - 1;
        if (rowIndex < 0 || rowIndex > 7) {
            throw new IllegalArgumentException("Illegal row: " + c);
        }
        return rowIndex;
    }

    private int col;
    private int row;
}
