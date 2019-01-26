package com.thoughtworks.game_of_life.ui.presenters;

import com.thoughtworks.game_of_life.core.CellState;
import com.thoughtworks.game_of_life.core.Location;
import com.thoughtworks.game_of_life.core.World;

public class CellToPresenterFactory {
    public static Presenter toPresenter(World world, Location location) {
        if (world.cellStateAtLocation(location) == CellState.IS_ALIVE){
            return new AliveCellPresenter(location);
        } else if(world.cellStateAtLocation(location) == CellState.IS_ZOMBIE) {
            return new ZombieCellPresenter(location);
        } else {
            return new DeadCellPresenter(location);
        }
    }
}
