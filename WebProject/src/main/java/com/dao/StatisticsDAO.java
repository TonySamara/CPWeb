package com.dao;

import javax.management.j2ee.statistics.Statistic;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public interface StatisticsDAO {
    public void addStatistic(Statistic statistic) throws SQLException;
    public void updateStatistic(Statistic statistic) throws SQLException;
    public Statistic getStatisticById(Long id) throws SQLException;
    public List getAllStatistic() throws SQLException;
    public void deleteStatistic(Statistic statistic) throws SQLException;
}
