package alexdev.fileclean.frameworkPackage;

import alexdev.fileclean.cleanPackage.FileWriterManagerService;
import alexdev.fileclean.frameworkPackage.mapper.FileMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileWriterManagerService fileManagerService;

    public FileController(FileWriterManagerService fileManagerService) {
        this.fileManagerService = fileManagerService;
    }


    @PostMapping
    ResponseEntity<Message> write(@RequestPart("file") MultipartFile multipartFile) {

        fileManagerService.writeFile(FileMapper.toAppFile(multipartFile));

        return ResponseEntity.ok(new Message("OK"));
    }

    record Message(String message) implements Serializable {}

}
