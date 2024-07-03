package pe.edu.cibertec.DSWII_T3_AponteJosue.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService {

    private final Path pathFolder = Paths.get("Images");

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        Files.copy(archivo.getInputStream(),this.pathFolder.resolve(archivo.getOriginalFilename()));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivosList) throws Exception {
        for(MultipartFile archivo : archivosList){
            validarTipoArchivo(archivo);
            this.guardarArchivo(archivo);
        }
    }

    private void validarTipoArchivo(MultipartFile archivo) throws IOException {
        String contentType = archivo.getContentType();
        if (contentType == null || !esTipoValido(contentType)) {
            throw new IllegalArgumentException("El tipo de archivo no es válido: " + archivo.getOriginalFilename());
        }
    }

    private boolean esTipoValido(String contentType) {
        return contentType.equals("image/png");
    }
}