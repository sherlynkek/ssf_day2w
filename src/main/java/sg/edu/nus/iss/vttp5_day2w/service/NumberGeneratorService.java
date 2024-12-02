package sg.edu.nus.iss.vttp5_day2w.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5_day2w.repo.NumberGeneratorRepo;

@Service
public class NumberGeneratorService {
    @Autowired
    NumberGeneratorRepo numberGeneratorRepo;

    // Purpose: Provides an interface for the controller or other application components to request a list of generated numbers
    // Delegation: Passes the numsToGenerate parameter to the repository and directly returns the result
    public List<String> getNumbers(int numsToGenerate) throws IOException{
        return numberGeneratorRepo.getNumbers(numsToGenerate);
    }
}