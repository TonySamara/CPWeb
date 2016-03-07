package com.models;

/**
 * Created by ANTON on 26.02.2016.
 */

import javax.persistence.*;


@Entity
@Table(name="Biography")

public class Biography {
    @Id
    @SequenceGenerator(name = "biography_seq", sequenceName = "biography_biography_id_seq", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "biography_seq")
    @Column(name="id_biography")
    private int id_biography;
    @Column(name="height")
    private int height;
    @Column(name="weight")
    private int weight;
    @Column(name="priortonba")
    private String priorToNBA;
    @Column(name="country")
    private String country;
    @Column(name="yearspro")
    private int yearsPro;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_player")
    private Player player;

    public Biography() {
    }

    public int getId_biography() {
        return id_biography;
    }

    public void setId_biography(int id_biography) {
        this.id_biography = id_biography;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPriorToNBA() {
        return priorToNBA;
    }

    public void setPriorToNBA(String priorToNBA) {
        this.priorToNBA = priorToNBA;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYearsPro() {
        return yearsPro;
    }

    public void setYearsPro(int yearsPro) {
        this.yearsPro = yearsPro;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
