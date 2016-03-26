package com.models;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by ANTON on 26.02.2016.
 */
@Entity
@OnDelete(
        action= OnDeleteAction.CASCADE)
@Table(name="Roster")
public class Player {
    @Id
    @SequenceGenerator(name = "player_seq", sequenceName = "player_player_id_seq", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @Column(name="id_player")
    private int id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="number")
    private int number;
    @Column(name="image")
    private String image;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_position")
    private Position position;

    public Player(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
