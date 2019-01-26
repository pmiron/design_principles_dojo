package com.thoughtworks.game_of_life.core;

public class ZombieCell implements Cell{
    @Override
    public CellState state() {
        return CellState.IS_ZOMBIE;
    }

    @Override
    public CellState willBeAliveNextState(int numberOfAliveNeighbours) {
        return CellState.IS_ZOMBIE;
    }
}
