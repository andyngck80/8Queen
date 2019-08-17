package com.fusion.coding;

public class ChessBoard {

    private static final int OCCUPIED = 1;
    private static final int ENGAGED = 2;

    private final int[][] grid = new int[8][8];

    public boolean placeQueen(String position) {
        GridPosition gridPos = GridPosition.parse(position);
        if (isOccupied(gridPos) || isEngaged(gridPos)) {
            return false;
        } else {
            markOccupied(gridPos);
            markEngagedGrid(gridPos);
        }
        return true;
    }

    private void markOccupied(GridPosition gridPos) {
        grid[gridPos.getCol()][gridPos.getRow()] = OCCUPIED;
    }

    private boolean isOccupied(GridPosition gridPos) {
        return grid[gridPos.getCol()][gridPos.getRow()] == OCCUPIED;
    }

    private boolean isEngaged(GridPosition gridPos) {
        return grid[gridPos.getCol()][gridPos.getRow()] == ENGAGED;
    }

    private void markEngagedGrid(GridPosition gridPosition) {
        markEastWest(gridPosition);
        markNorthSouth(gridPosition);
        markNorthEastToSouthWest(gridPosition);
        markNorthWestToSouthEast(gridPosition);
    }

    private void markNorthWestToSouthEast(GridPosition gridPosition) {
        int ns = gridPosition.getRow() + 1, ew = gridPosition.getCol() - 1;
        while (ns <= 7 && ew >= 0) {
            grid[ew][ns] = ENGAGED;
            ns++;
            ew--;
        }

        ns = gridPosition.getRow() - 1;
        ew = gridPosition.getCol() + 1;
        while (ns >= 0 && ew <= 7) {
            grid[ew][ns] = ENGAGED;
            ns--;
            ew++;
        }
    }

    private void markNorthEastToSouthWest(GridPosition gridPosition) {
        int ns = gridPosition.getRow() + 1, ew = gridPosition.getCol() + 1;
        while (ns <= 7 && ew <= 7) {
            grid[ew][ns] = ENGAGED;
            ns++;
            ew++;
        }

        ns = gridPosition.getRow() - 1;
        ew = gridPosition.getCol() - 1;
        while (ns >= 0 && ew >= 0) {
            grid[ew][ns] = ENGAGED;
            ns--;
            ew--;
        }
    }

    private void markNorthSouth(GridPosition gridPosition) {
        for (int ns = 7; ns >= 0; ns--) {
            if (ns == gridPosition.getRow()) {
                continue;
            }
            grid[gridPosition.getCol()][ns] = ENGAGED;
        }
    }

    private void markEastWest(GridPosition gridPosition) {
        for (int ew = 7; ew >= 0; ew--) {
            if (ew == gridPosition.getCol()) {
                continue;
            }
            grid[ew][gridPosition.getRow()] = ENGAGED;
        }
    }

}