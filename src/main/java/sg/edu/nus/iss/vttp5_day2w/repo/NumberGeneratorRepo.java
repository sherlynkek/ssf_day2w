package sg.edu.nus.iss.vttp5_day2w.repo;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5_day2w.model.NumberGenerator;

@Repository
// Input: Takes numsToGenerate as the number of random numbers (images) to generate
// Logic:
// Creates a new instance of the NumberGenerator class, passing numsToGenerate as the parameter
// Calls the generateNums() method on the NumberGenerator instance to produce the list of numbers
// Output: Returns the generated list of random numbers (as file names)
public class NumberGeneratorRepo {
    public List<String> getNumbers(int numsToGenerate) throws IOException{
        return new NumberGenerator(numsToGenerate).generateNums();
    }
}