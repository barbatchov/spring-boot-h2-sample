package br.com.cast.crud.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class OS {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
}
