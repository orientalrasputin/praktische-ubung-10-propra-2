package projektor.web;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import projektor.projekt.Projekt;
import projektor.projekt.ProjektRepository;
import projektor.projekt.Repository;

@Controller
public class ProjektController {

  @Autowired
  Repository repo2;

  @GetMapping("/")
  public String index(Model model, String person, String startzeitpunkt, String endzeitpunkt) {
    if (person != null) {
      model.addAttribute("projekte", repo2.allPerson(person));
    }
    else if(startzeitpunkt!=null && endzeitpunkt != null) {
      LocalDate von = LocalDate.parse(startzeitpunkt);
      LocalDate bis = LocalDate.parse(endzeitpunkt);
      //model.addAttribute("projekte", repo2.findByZeitraum_vonGreaterThanAndZeitraum_bisLessThan(von, bis));
    }
    else
    model.addAttribute("projekte", repo2.findAll());
    return "liste";
  }

  @GetMapping("/details/{id}")
  public String details(Model model, @PathVariable long id) {
    Projekt projekt = repo2.findById(id).get();
    model.addAttribute("projekt", projekt);
    return "details";
  }

  @PostMapping("/edit/{id}")
  public String edit(@PathVariable long id, String beschreibung,
                     String startzeitpunkt, String endzeitpunkt) {
    Projekt projekt = repo2.findById(id).get();
    projekt.setBeschreibung(beschreibung);
    LocalDate von = LocalDate.parse(startzeitpunkt);
    LocalDate bis = LocalDate.parse(endzeitpunkt);
    projekt.setZeitraum(von, bis);
    repo2.save(projekt);
    return "redirect:/";
  }

  @PostMapping("/addperson/{id}")
  public String addPerson(@PathVariable long id, String person) {
    Projekt projekt = repo2.findById(id).get();
    projekt.addPerson(person);
    repo2.save(projekt);
    return "redirect:/";
  }


}
