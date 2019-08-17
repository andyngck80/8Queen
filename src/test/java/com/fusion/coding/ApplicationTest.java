package com.fusion.coding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.fusion.coding.Application.hasEngagingQueens;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    static Stream<Arguments> arrayOfNonAttackingQueens() {
        return Stream.of(
                Arguments.of((Object) new String[] {"a3", "b8", "c4", "d7", "e1", "f6", "g2", "h5"}),
                Arguments.of((Object) new String[] {"a1"}),
                Arguments.of((Object) new String[] {"b8", "c4", "d7", "e1", "f6", "g2", "h5"})
        );
    }

    static Stream<Arguments> arrayOfAttackingQueens() {
        return Stream.of(
                Arguments.of((Object) new String[] {"a3", "b8", "c4", "d7", "e1", "f5", "g2", "h6"}),
                Arguments.of((Object) new String[] {"d4", "h8"}),
                Arguments.of((Object) new String[] {"d4", "d7"}),
                Arguments.of((Object) new String[] {"d4", "c5"}),
                Arguments.of((Object) new String[] {"d4", "b4"}),
                Arguments.of((Object) new String[] {"d4", "a1"}),
                Arguments.of((Object) new String[] {"d4", "d3"}),
                Arguments.of((Object) new String[] {"d4", "g1"}),
                Arguments.of((Object) new String[] {"d4", "g4"})
        );
    }

    static Stream<Arguments> arrayOfInvalidPositions() {
        return Stream.of(
                Arguments.of((Object) new String[] {"", "a3"}), // blank position
                Arguments.of((Object) new String[] {"a3", "i8", "c4", "d7", "e1", "f5", "g2", "h6"}), // i8 is invalid
                Arguments.of((Object) new String[] {"a3", "b9", "c4", "d7", "e1", "f5", "g2", "h6"}) // b9 is invalid
        );
    }

    @ParameterizedTest
    @MethodSource("arrayOfNonAttackingQueens")
    public void _nonAttackingQueens_shouldReturnFalse(String... args) {
        assertFalse(hasEngagingQueens(args));
    }

    @ParameterizedTest
    @MethodSource("arrayOfAttackingQueens")
    public void _attackingQueens_shouldReturnTrue(String... args) {
        assertTrue(hasEngagingQueens(args));
    }

    @ParameterizedTest
    @MethodSource("arrayOfInvalidPositions")
    public void _invalidPosition_shouldThrowException(String... args) {
        assertThrows(IllegalArgumentException.class, () -> hasEngagingQueens(args));
    }
}
