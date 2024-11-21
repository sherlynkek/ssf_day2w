package sg.edu.nus.iss.vttp5_day2w.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.util.ResourceUtils;

public class NumberGenerator {
    private int numsToGenerate;

    public NumberGenerator(int numsToGenerate){
        this.numsToGenerate = numsToGenerate;
    }

    public List<String> generateNums() throws IOException{
        File[] numbersImages = ResourceUtils.getFile("classpath:static/numbers").listFiles();
        List<String> imagesFiles = new ArrayList<>();
        Random random = new Random();
        for(File file:numbersImages){
            imagesFiles.add(file.getName());
        }

        List<String> numList = new ArrayList<>();
        for(int i = 0; i < numsToGenerate; i++){
            numList.add(imagesFiles.get(random.nextInt(imagesFiles.size())));
        }
        return numList;
    }
}