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

    public List<String> getNumbers(int numsToGenerate) throws IOException{
        return numberGeneratorRepo.getNumbers(numsToGenerate);
    }
}