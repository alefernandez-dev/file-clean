package alexdev.fileclean.cleanPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileWriterManagerService {

    private final static Logger log = LoggerFactory.getLogger(FileWriterManagerService.class);

    private final static String DIRECTORY;

    static {
        String envDirectory = System.getenv("FILES_DIRECTORY");
        if (envDirectory != null && !envDirectory.isEmpty()) {
            DIRECTORY = envDirectory;
        } else {
            DIRECTORY = "/files";
        }
    }

    public void writeFile(AppFile appFile) {

        var destination = Path.of(DIRECTORY, appFile.filename());
        try {
            Files.copy(appFile.inputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {

            var message = String.format("Failed to write file '%s'", appFile.filename());

            log.error(message, e);
            throw new FileWriteException(message, e);
        }
    }

}
