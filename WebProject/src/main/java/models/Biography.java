package models;

/**
 * Created by ANTON on 26.02.2016.
 */

import javax.persistence.*;


@Entity
@Table(name="Biography")

public class Biography {
    @Id
    @Column(name="id_biography")
    @GeneratedValue
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
    @Column(name="id_player")
    private int id_player;

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

    public int getId_player() {
        return id_player;
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }
}
