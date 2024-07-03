package pe.edu.cibertec.DSWII_T3_AponteJosue.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDomicilio;
    private String descDomicilio;
    private int nroDomicilio;
    private String refDomicilio;
}