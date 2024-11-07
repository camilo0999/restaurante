package com.electiva.restaurante.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenServiceImp implements ImagenServices{

    @Value("${app.imgService.dir}")
    private String uploadDir;

    @Override
    public String unaImagen(MultipartFile file) {
         try {
            // Obtener el nombre limpio del archivo
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // Verificar si el nombre de archivo es válido
            if (fileName.contains("..")) {
                throw new Exception("Nombre de archivo no válido: " + fileName);
            }

            // Generar un nombre único para el archivo
            String newFileName = UUID.randomUUID().toString() + "_" + fileName;

            // Crear la carpeta de carga si no existe
            Path dirPath = Paths.get(uploadDir);
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            // Guardar el archivo en la carpeta de carga
            Path filePath = dirPath.resolve(newFileName);
            Files.copy(file.getInputStream(), filePath);

            // Devolver la URL de la imagen
            return "/ImagenServicio/" + newFileName; // Ejemplo: "/uploads/12345_imagen.jpg"
        } catch (Exception e) {
            // Manejar cualquier error
            e.printStackTrace();
            return null;
        }
    }

}
