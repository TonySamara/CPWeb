import com.dao.PlayerDAO;
import com.dao.PlayerDAOImpl;
import com.dao.StatisticsDAOImpl;
import com.models.Player;
import com.models.Position;
import com.models.Statistics;
import javafx.geometry.Pos;

import java.sql.SQLException;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by ANTON on 21.04.2016.
 */
public class test {
    public static void main(String [] args) throws SQLException {
        PlayerDAOImpl playerDAO = new PlayerDAOImpl();
        Player player = playerDAO.getPlayerById(1);
        StatisticsDAOImpl statisticsDAO = new StatisticsDAOImpl();
        List<Statistics> statisticses =statisticsDAO.getStatByPlayerId(player);
        Statistics statistics = statisticses.get(0);
        System.out.print(statistics.getApg());
    }
}
