package com.models;

import javax.persistence.*;

/**
 * Created by ANTON on 26.02.2016.
 */
@Entity
@Table(name="Statistics")
public class Statistics {
    @Id
    @SequenceGenerator(name = "stat_seq", sequenceName = "stat_stat_id_seq", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stat_seq")
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_player")
    private Player player;

    public Statistics(){

    }

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
