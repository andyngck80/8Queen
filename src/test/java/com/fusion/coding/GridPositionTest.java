package com.fusion.coding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GridPositionTest {

    @Test
    public void shouldReturnGridPosition() {
        GridPosition gp = GridPosition.parse("a5");
        assertEquals(0, gp.getCol());
        assertEquals(4, gp.getRow());
    }

    @Test
    public void shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> GridPosition.parse("i1"));
    }
}
