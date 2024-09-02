package alexdev.fileclean.frameworkPackage.mapper;

import alexdev.fileclean.cleanPackage.AppFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public final class FileMapper {
    private FileMapper() {
    }

    public static AppFile toAppFile(MultipartFile multipartFile) {
        try {
            return new AppFile(multipartFile.getOriginalFilename(), multipartFile.getInputStream());
        } catch (IOException e) {
            throw new FileMapperException("Error converting multipart file");
        }
    }
}
