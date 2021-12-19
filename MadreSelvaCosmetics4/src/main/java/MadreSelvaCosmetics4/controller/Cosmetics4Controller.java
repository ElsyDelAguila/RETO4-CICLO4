package MadreSelvaCosmetics4.controller;


import MadreSelvaCosmetics4.model.Cosmetics4;
import MadreSelvaCosmetics4.service.Cosmetics4Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elsy Del Águila
 */
@RestController
@RequestMapping("/api/cosmetics")
@CrossOrigin("*")
public class Cosmetics4Controller {

    @Autowired
    private Cosmetics4Service Cosmetics4Service;

    @GetMapping("/all")
    public List<Cosmetics4> getAll() {
        return Cosmetics4Service.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cosmetics4> getCosmetics4(@PathVariable("reference") String reference) {
        return Cosmetics4Service.getCosmetics4(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics4 create(@RequestBody Cosmetics4 gadget) {
        return Cosmetics4Service.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics4 update(@RequestBody Cosmetics4 gadget) {
        return Cosmetics4Service.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return Cosmetics4Service.delete(reference);
    }
}
