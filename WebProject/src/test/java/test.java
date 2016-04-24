import com.dao.PlayerDAO;
import com.dao.PlayerDAOImpl;
import com.dao.PositionDAOImpl;
import com.dao.StatisticsDAOImpl;
import com.models.Player;
import com.models.Position;
import com.models.Statistics;
import javafx.geometry.Pos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by ANTON on 21.04.2016.
 */
public class test {
    public static void main(String [] args) throws SQLException {
        List<Position> positionList = new ArrayList<Position>();
        PositionDAOImpl positionDAO = new PositionDAOImpl();
        positionList = positionDAO.getAllPosition();
        for (Position pos: positionList){
            System.out.println(pos.getPosition());
        }
        PlayerDAOImpl playerDAO = new PlayerDAOImpl();
        Player player = playerDAO.getPlayerById(2);
        Position position = player.getPosition();
        boolean check;
        for (Position pos: positionList){
            check=true;
            if (pos.getId_position()== position.getId_position()) check=false;
            if (check==true){
               System.out.println(position.getPosition());
            }
        }

    }
}
