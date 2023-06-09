package backend.exam.controllers;

import backend.exam.entities.AirDefEntity;
import backend.exam.repositories.AirDefRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/exam/api")
@Slf4j
public class AirDefController {
    @Autowired
    private AirDefRepository cRepo;

    @GetMapping("/list")
    public List<AirDefEntity> getAirDefs() {
        List<AirDefEntity> AirDefsList = cRepo.findAll();
        log.info("[AirDef CONTROLLER] GET method performed: found {} AirDefs", AirDefsList.size());
        return AirDefsList;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AirDefEntity postAirDef(@RequestBody AirDefEntity AirDef) {
        cRepo.save(AirDef);
        log.info("[AirDef CONTROLLER] POST method performed: added {} AirDef", AirDef.getName());
        return AirDef;
    }

    @PutMapping("/update/{id}")
    public AirDefEntity putAirDef(@PathVariable long id, @RequestBody AirDefEntity updatedAirDef) {
        AirDefEntity newAirDef = cRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No AirDef found with id:" + id));

        newAirDef.setName(updatedAirDef.getName());
        newAirDef.setImg(updatedAirDef.getImg());
        newAirDef.setPrice(updatedAirDef.getPrice());

        log.info("[AirDef CONTROLLER] PUT method performed: AirDef with id {} was updated", id);
        return cRepo.save(newAirDef);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAirDef(@PathVariable long id) {
        AirDefEntity delAirDef = cRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No AirDef found with id:" + id));

        cRepo.delete(delAirDef);
        log.info("[AirDef CONTROLLER] DELETE method performed: AirDef with id {} was deleted", id);
    }
}
