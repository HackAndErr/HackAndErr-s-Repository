package org.example.tg.bot.providers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class FileTokenProvider implements TokenProvider{
    Logger logger = Logger.getLogger(FileTokenProvider.class.getName());
    private final Path pathToFile;

    public FileTokenProvider(Path pathToFile){
        this.pathToFile = pathToFile;
    }

    public FileTokenProvider(String pathToFile){
        this.pathToFile = Paths.get(pathToFile);
    }

    @Override
    public String get(){
        try{
            return Files.readString(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Some exception in " + pathToFile.toString());
        }
        return null;
    }
}
