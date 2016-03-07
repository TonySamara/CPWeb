package com.dao;

import com.models.Player;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public interface PlayerDAO {
    public void addPlayer(Player player) throws SQLException;
    public void updatePlayer(Player player) throws SQLException;
    public Player getPlayerById(Long id) throws SQLException;
    public List getAllPlayers() throws SQLException;
    public void deletePlayer(Player player) throws SQLException;
}
