package sg.edu.nus.iss.vttp5_day2w.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.ResourceUtils;

public class NumberGenerator {
    private int numsToGenerate;

    public NumberGenerator(int numsToGenerate){
        this.numsToGenerate = numsToGenerate;
    }

    public List<String> generateNums() throws IOException {

    // File Retrieval
    // uses ResourceUtils.getFile("classpath:static/numbers") to locate a directory within the resources/static/numbers path of your Spring Boot project
    // listFiles() retrieves all files in the specified directory as an array of File objects
    File[] numbersImages = ResourceUtils.getFile("classpath:static/numbers").listFiles();
    
    // If the directory static/numbers does not exist or is empty, numbersImages could be null
    if (numbersImages == null || numbersImages.length == 0) {
        throw new IOException("No files found in the directory static/numbers");
    }


    List<String> imagesFiles = new ArrayList<>();

    // The filenames (e.g., 1.png, 2.jpg) are extracted from the File objects and added to the imagesFiles list
    for (File file : numbersImages) {
        imagesFiles.add(file.getName());
    }

    // if you want unique numbers and the count exceeds the available files, the random selection will fail
    if (numsToGenerate > imagesFiles.size()) {
        throw new IllegalArgumentException("Cannot generate more unique numbers than available files");
    }

    
    Collections.shuffle(imagesFiles); // Randomize the order
    return new ArrayList<>(imagesFiles.subList(0, numsToGenerate)); // Get required number of files
}

}