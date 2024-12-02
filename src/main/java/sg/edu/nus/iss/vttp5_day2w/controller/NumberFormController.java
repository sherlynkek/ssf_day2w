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
@RequestMapping("/numberform") // Sets a base path for all request mappings in this controller
public class NumberFormController {

    @Autowired // Injects the NumberGeneratorService bean, which presumably contains the logic for generating numbers
    NumberGeneratorService numberGeneratorService;
    // to store the generated numbers and the number of items to generate
    List<String> numList;
    int numsToGenerate;
    
    // Displaying the form
    // Mapping: Handles GET /numberform
    // Purpose: Displays a form (number.html) where users can input the number of items to generate
    // Return: The name of the view (number), which Spring resolves to number.html
    @GetMapping("")
    public String numberForm(){
        return "number";
    }

    // Handling Form Submission
    // Mapping: Handles POST /numberform
    // Parameters:
    // @RequestParam("number") int number: Captures the value of the number input field from the submitted form
    // RedirectAttributes redirectAttributes: Used to store data for the redirected view
    @PostMapping("")
    public String getNumber(@RequestParam("number") int number, RedirectAttributes redirectAttributes) throws IOException {
        // the number input value is stored in numsToGenerate
        numsToGenerate = number;
        // the service numberGeneratorService.getNumbers(numsToGenerate) generates the list of numbers
        numList = numberGeneratorService.getNumbers(numsToGenerate);

        // stores data for the next view
        redirectAttributes.addFlashAttribute("numsToGenerate", numsToGenerate);
        redirectAttributes.addFlashAttribute("numList", numList);
        // redirects to /numberform/numberlist
        return "redirect:/numberform/numberlist";
    }


    // Displaying the Generated Number
    // Mapping: Handles GET /numberform/numberlist
    // Parameters:
    // @ModelAttribute("numsToGenerate") Integer numsToGenerate: Retrieves the flash attribute numsToGenerate
    // @ModelAttribute("numList") List<Integer> numList: Retrieves the flash attribute numList
    // Model model: Used to pass data to the view
    // Logic:
    // Retrieves the flash attributes (numsToGenerate and numList) and adds them to the model.
    // Returns the view name numberlist, which likely displays the list of numbers.

    @GetMapping("/numberlist")
    public String displayNumberList(@ModelAttribute("numsToGenerate") Integer numsToGenerate, @ModelAttribute("numList") List<Integer> numList, Model model){
        model.addAttribute("numsToGenerate", numsToGenerate);
        model.addAttribute("numList", numList);
        return "numberlist";
    }
}