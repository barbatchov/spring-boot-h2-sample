package br.com.cast.crud.rest;

import br.com.cast.crud.domain.OS;
import br.com.cast.crud.repository.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/os")
public class OSRest {
    @Autowired
    private OSRepository osRepository;

    @GetMapping
    public OS get(@RequestParam(value = "id") Integer id) {
        return osRepository.findById(id);
    }

    @PutMapping
    public void put(@RequestBody OS os) {
        osRepository.save(os);
    }

    @DeleteMapping
    public void delete(@RequestParam(value = "id") Integer id) {
        osRepository.delete(id);
    }
}
