package net.hkapp.notes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="CLIENT_TABLE")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CLIENT_ID")
    private Integer clientId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="STREET_ADDRESS")
    private String streetAddress;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="ZIP_CODE")
    private String zipCode;
}
