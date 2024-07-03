package pe.edu.cibertec.DSWII_T3_AponteJosue.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.DSWII_T3_AponteJosue.model.dto.DtoEntity;
import pe.edu.cibertec.DSWII_T3_AponteJosue.service.IPublicacionService;
import pe.edu.cibertec.DSWII_T3_AponteJosue.util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("api/pubs-dto")
public class PublicacionController {

    private IPublicacionService iPublicacionService;

    @GetMapping("")
    @PreAuthorize("hasRole('COORDINADOR')")
    public ResponseEntity<List<DtoEntity>> listaPublicacionDto(){
        List<DtoEntity> publicacionDtoList = new ArrayList<>();
        publicacionDtoList = iPublicacionService.listarPublicaciones()
                .stream()
                .map(x -> new DtoUtil().convertirPublicacionAPublicacionDto(x))
                .collect(Collectors.toList());
        if(publicacionDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(publicacionDtoList, HttpStatus.OK);
    }
}
