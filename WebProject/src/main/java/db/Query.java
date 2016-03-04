package db;

import models.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 25.02.2016.
 */
public class Query {

    public List<Player> selectRoster(Connection conn) throws SQLException, ClassNotFoundException {
        Statement statement = conn.createStatement();
        List<Player> roster = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM \"Roster\"");
        while (rs.next()){
            Player player = new Player();
            player.setId(rs.getInt("id_player"));
            player.setFirstname(rs.getString("firstname"));
            player.setLastname(rs.getString("lastname"));
            player.setNumber(rs.getInt("number"));
            player.setImage(rs.getString("image"));
            player.setId_position(rs.getInt("id_position"));
            roster.add(player);
        }
        return roster;
    }
}
