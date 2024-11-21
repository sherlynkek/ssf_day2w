package sg.edu.nus.iss.vttp5_day2w.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.nus.iss.vttp5_day2w.service.NumberGeneratorService;


@Controller
@RequestMapping("/numberform")
public class NumberFormController {
    @Autowired
    NumberGeneratorService numberGeneratorService;
    List<String> numList;
    int numsToGenerate;
    
    @GetMapping("")
    public String numberForm(){
        return "number";
    }

    @PostMapping("")
    public String getNumber(@RequestParam("number") int number, RedirectAttributes redirectAttributes) throws IOException {
        numsToGenerate = number;
        numList = numberGeneratorService.getNumbers(numsToGenerate);

        //Stores data for the next view
        redirectAttributes.addFlashAttribute("numsToGenerate", numsToGenerate);
        redirectAttributes.addFlashAttribute("numList", numList);
        return "redirect:/numberform/numberlist";
    }

    @GetMapping("/numberlist")
    public String displayNumberList(@ModelAttribute("numsToGenerate") Integer numsToGenerate, @ModelAttribute("numList") List<Integer> numList, Model model){
        model.addAttribute("numsToGenerate", numsToGenerate);
        model.addAttribute("numList", numList);
        return "numberlist";
    }


    
}