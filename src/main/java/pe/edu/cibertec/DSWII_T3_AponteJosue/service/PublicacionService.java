package pe.edu.cibertec.DSWII_T3_AponteJosue.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_T3_AponteJosue.model.bd.Publicacion;
import pe.edu.cibertec.DSWII_T3_AponteJosue.repository.PublicacionRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PublicacionService implements IPublicacionService {


    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> listarPublicaciones() {
        return publicacionRepository.findAll();
    }
}
