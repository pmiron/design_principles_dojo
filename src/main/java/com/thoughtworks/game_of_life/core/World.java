package com.thoughtworks.game_of_life.core;

import java.util.HashMap;
import java.util.Map;

import static com.thoughtworks.game_of_life.core.Location.allWorldLocations;

public class World {

    public static final int DEFAULT_WIDTH = 10;
    public static final int DEFAULT_HEIGHT = 10;


    Map<Location, Cell> cells;

    public World()  {
        cells = initCells();
    }

    public void advance() {
        Map<Location, Cell> newCells = initCells();

        for (Location location : allWorldLocations(DEFAULT_WIDTH, DEFAULT_HEIGHT)) {
            if (cells.get(location).willBeAliveNextState(numberOfAliveNeighbours(location)) == CellState.IS_ALIVE){
                newCells.put(location, new AliveCell());
            }
            if (cells.get(location).willBeAliveNextState(numberOfAliveNeighbours(location)) == CellState.IS_ZOMBIE){
                newCells.put(location, new ZombieCell());
            }
        }
        cells = newCells;
    }

    public boolean isEmpty() {
        for (Cell cell: cells.values()) {
            if (cell.state() == CellState.IS_ALIVE || cell.state() == CellState.IS_ZOMBIE){
                return false;
            }
        }
        return true;
    }

    public void setLiving(Location location) {
        cells.put(location, new AliveCell());
    }

    public CellState cellStateAtLocation(Location location) {
        return cells.get(location).state();
    }

    private Map<Location,Cell> initCells() {
        Map<Location, Cell> cells = new HashMap<Location, Cell>();
        for (Location location : allWorldLocations(DEFAULT_WIDTH, DEFAULT_HEIGHT)) {
            cells.put(location, new DeadCell());
        }
        return cells;
    }

    public int numberOfAliveNeighbours(Location l) {
        int aliveNeighbours = 0;

        for (Location location : l.allNeighbours(DEFAULT_WIDTH, DEFAULT_HEIGHT)){
            if (cells.get(location).state() == CellState.IS_ALIVE || cells.get(location).state() == CellState.IS_ZOMBIE){
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

}
