package models;

import javax.persistence.*;

/**
 * Created by ANTON on 26.02.2016.
 */
@Entity
@Table(name="Position")
public class Position {
    @Id
    @Column(name="id_position")
    @GeneratedValue
    private int id_position;
    @Column(name="position")
    private String position;

    public int getId_position() {
        return id_position;
    }

    public void setId_position(int id_position) {
        this.id_position = id_position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
