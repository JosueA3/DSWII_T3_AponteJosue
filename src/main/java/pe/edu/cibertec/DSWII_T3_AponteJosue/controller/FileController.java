package pe.edu.cibertec.DSWII_T3_AponteJosue.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.DSWII_T3_AponteJosue.model.dto.ArchivoDto;
import pe.edu.cibertec.DSWII_T3_AponteJosue.service.FileService;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/filesimages")
public class FileController {

    private FileService fileService;

    @PostMapping("")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<ArchivoDto> subirArchivos(@RequestParam("files") List<MultipartFile> multipartFiles) throws Exception{
        fileService.guardarArchivos(multipartFiles);
        return new ResponseEntity<>(ArchivoDto.builder().mensaje("Archivos subidos correctamente").build(), HttpStatus.OK);
    }
}
