package dev.java10x.ninjasregister.Ninjas;

import dev.java10x.ninjasregister.Missions.MissionsModel;
import dev.java10x.ninjasregister.Missions.MissionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;
    private final MissionsService missionsService;

    public NinjaControllerUi(NinjaService ninjaService, MissionsService missionsService) {
        this.ninjaService = ninjaService;
        this.missionsService = missionsService;
    }

    @GetMapping("/list")
    public String listNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listNinjas";
    }

    @GetMapping("/delete/{id}")
    public String deleteNinjasById(@PathVariable Long id) {
        ninjaService.deleteNinjasById(id);
        return "redirect:/ninjas/ui/list";
    }

    @GetMapping("/list/{id}")
    public String getNinjaById(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.getNinjaById(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detailsNinja";
        } else {
            model.addAttribute("message", "Ninja not found");
            return "listNinjas";
        }
    }

    @GetMapping("/create")
    public String createNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "createNinja";
    }

    @PostMapping("/save")
    public String saveNinja(@ModelAttribute NinjaDTO ninja, @RequestParam(required = false) Long missionId,
                            RedirectAttributes redirectAttributes) {

        if (missionId != null) {
            MissionsModel mission = missionsService.getMissionById(missionId);
            if (mission != null) {
                ninja.setMissions(mission);
            }
        }

        ninjaService.createNinja(ninja);
        redirectAttributes.addFlashAttribute("message", "Ninja successfully added!");
        return "redirect:/ninjas/ui/list";
    }

    @GetMapping("/update/{id}")
    public String editNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.getNinjaById(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "updateNinja"; // template Thymeleaf
        } else {
            model.addAttribute("message", "Ninja not found");
            return "listNinjas";
        }
    }

    @PostMapping("/update")
    public String saveUpdatedNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        NinjaDTO existingNinja = ninjaService.getNinjaById(ninja.getId());

        if (existingNinja != null) {
            ninja.setMissions(existingNinja.getMissions());
            ninjaService.updateNinja(ninja, ninja.getId());
            redirectAttributes.addFlashAttribute("message", "Ninja updated successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Ninja not found!");
        }

        return "redirect:/ninjas/ui/list";
    }

}
