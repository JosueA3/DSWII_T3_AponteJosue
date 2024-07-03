package pe.edu.cibertec.DSWII_T3_AponteJosue.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_T3_AponteJosue.model.bd.Publicacion;
import pe.edu.cibertec.DSWII_T3_AponteJosue.model.dto.DtoEntity;
import pe.edu.cibertec.DSWII_T3_AponteJosue.model.dto.PublicacionDto;

@Component
public class DtoUtil {


    public DtoEntity convertirADto(Object obj, DtoEntity mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }
    public Object convertirDtoAEntity(Object obj, DtoEntity mapper){
        return new ModelMapper().map(mapper, obj.getClass());
    }

    public PublicacionDto convertirPublicacionAPublicacionDto(Publicacion publicacion) {
        PublicacionDto publicacionDto = new ModelMapper().map(publicacion, PublicacionDto.class);
        publicacionDto.setNomAutor(publicacion.getAutor().getNomAutor());
        publicacionDto.setApeAutor(publicacion.getAutor().getApeAutor());
        return publicacionDto;
    }
}