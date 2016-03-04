package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ANTON on 26.02.2016.
 */
@Entity
@Table(name="Statistics")
public class Statistics {
    @Id
    @Column(name="id_statistics")
    private int id_statistics;
    @Column(name="ppg")
    private double ppg;
    @Column(name="rpg")
    private double rpg;
    @Column(name="apg")
    private double apg;
    @Column(name="fg")
    private double fg;
    @Column(name="id_player")
    private int id_player;

    public int getId_statistics() {
        return id_statistics;
    }

    public void setId_statistics(int id_statistics) {
        this.id_statistics = id_statistics;
    }

    public double getPpg() {
        return ppg;
    }

    public void setPpg(double ppg) {
        this.ppg = ppg;
    }

    public double getRpg() {
        return rpg;
    }

    public void setRpg(double rpg) {
        this.rpg = rpg;
    }

    public double getApg() {
        return apg;
    }

    public void setApg(double apg) {
        this.apg = apg;
    }

    public double getFg() {
        return fg;
    }

    public void setFg(double fg) {
        this.fg = fg;
    }

    public int getId_player() {
        return id_player;
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }
}
