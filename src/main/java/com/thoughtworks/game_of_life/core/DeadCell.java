package com.thoughtworks.game_of_life.core;

public class DeadCell implements Cell{

    @Override
    public CellState state() {
        return CellState.IS_DEAD;
    }

    @Override
    public CellState willBeAliveNextState(int numberOfAliveNeighbours) {
        if(numberOfAliveNeighbours >= 4)
            return CellState.IS_ZOMBIE;
        else if(numberOfAliveNeighbours == 3)
            return CellState.IS_ALIVE;
        else
            return CellState.IS_DEAD;
    }
}
