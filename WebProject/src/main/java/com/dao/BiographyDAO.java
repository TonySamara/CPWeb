package com.dao;



import com.models.Biography;
import com.models.Player;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public interface BiographyDAO {
    public void addBiography(Biography biography) throws SQLException;
    public void updateBiography(Biography biography) throws SQLException;
    public Biography getBiographyById(int id) throws SQLException;
    public List getAllBiography() throws SQLException;
    public void deleteBiography(Biography biography) throws SQLException;
    public void delBiographyByPlayer(int id) throws SQLException;
    public List<Biography> getBiographyByPlayerId(Player player) throws SQLException;
}
