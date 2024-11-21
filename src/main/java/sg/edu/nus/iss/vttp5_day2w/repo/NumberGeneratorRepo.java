package sg.edu.nus.iss.vttp5_day2w.repo;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5_day2w.model.NumberGenerator;

@Repository
public class NumberGeneratorRepo {
    public List<String> getNumbers(int numsToGenerate) throws IOException{
        return new NumberGenerator(numsToGenerate).generateNums();
    }
}