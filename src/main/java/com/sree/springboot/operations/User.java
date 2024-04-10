package com.sree.springboot.operations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@AllArgsConstructor
@Getter
@Builder
@Entity
@NoArgsConstructor
@Table(name = "USERDETAIL")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address")
    private String address;

    @Override
    public String toString(){
        return String.format("User : [name: %s, age: %s, address: %s, passportNumber: %s]", name, age, address);
    }
}
