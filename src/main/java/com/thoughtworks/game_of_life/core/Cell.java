package com.thoughtworks.game_of_life.core;

public interface Cell {
    CellState state();
    CellState willBeAliveNextState(int numberOfAliveNeighbours);
}
