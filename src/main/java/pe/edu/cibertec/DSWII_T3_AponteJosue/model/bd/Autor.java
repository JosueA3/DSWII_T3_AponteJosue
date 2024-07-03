package pe.edu.cibertec.DSWII_T3_AponteJosue.model.bd;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAutor;
    private String nomAutor;
    private String apeAutor;
    private String fechNacAutor;

}