package com.dao;


import com.models.Position;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public interface PositionDAO {
    public void addPosition(Position position) throws SQLException;
    public void updatePosition(Position position) throws SQLException;
    public Position getPositionById(Long id) throws SQLException;
    public List getAllPosition() throws SQLException;
    public void deletePosition(Position position) throws SQLException;
}
