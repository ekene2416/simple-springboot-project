package com.ekene.simplespringbootproject.user;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Appuser_id")
@SequenceGenerator(name = "Appuser_id",sequenceName = "Appuser_id",allocationSize = 1)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Integer views;

}
