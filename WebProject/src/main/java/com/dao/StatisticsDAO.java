package com.dao;




import com.models.Biography;
import com.models.Player;
import com.models.Statistics;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public interface StatisticsDAO {
    public void addStatistic(Statistics statistic) throws SQLException;
    public void updateStatistic(Statistics statistic) throws SQLException;
    public Statistics getStatisticById(int id) throws SQLException;
    public List getAllStatistic() throws SQLException;
    public void deleteStatistic(Statistics statistic) throws SQLException;
    public void delStatByPlayer(int id) throws SQLException;
    public List<Statistics> getStatByPlayerId(Player player) throws SQLException;
}
