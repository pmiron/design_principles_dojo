package com.thoughtworks.game_of_life.core;

public class AliveCell implements Cell{

    @Override
    public CellState state() {
        return CellState.IS_ALIVE;
    }

    @Override
    public CellState willBeAliveNextState(int numberOfAliveNeighbours) {
        if(numberOfAliveNeighbours >= 4)
            return CellState.IS_ZOMBIE;
        else if(numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3)
            return CellState.IS_ALIVE;
        else return CellState.IS_DEAD;
    }

}
