package me.daniel.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlatController {

    @Autowired
    private FlatRepo repo;

    @GetMapping("/flats/{id}")
    public Flat getFlat(@PathVariable Long id) throws FlatNotFoundException {
        return repo.findById(id).orElseThrow(FlatNotFoundException::new);
    }

    @GetMapping("/flats")
    public List<Flat> getAllFlats() {
        return (List<Flat>) repo.findAll();
    }

    @GetMapping("/flats/city/{city}")
    public List<Flat> getByCity(@PathVariable String city)
    {
        return repo.findByCity(city);
    }

    @PostMapping("/flats")
    Flat newFlat(@RequestBody Flat newFlat) {
        return repo.save(newFlat);
    }

    @PutMapping("/flats/{id}")
    public Flat replaceFlat(@RequestBody Flat newFlat, @PathVariable Long id)
    {
        return repo.findById(id)
                .map(flat -> {
                    flat.setCity(newFlat.getCity());
                    flat.setFlatNumber(newFlat.getFlatNumber());
                    flat.setBuildingNumber(newFlat.getBuildingNumber());
                    flat.setPrice(newFlat.getPrice());
                    flat.setMetric(newFlat.getMetric());
                    flat.setStreet(newFlat.getStreet());
                    flat.setNumberOfRooms(newFlat.getNumberOfRooms());

                    return repo.save(flat);
                })
                .orElseGet(() -> {
                    newFlat.setId(id);
                    return repo.save(newFlat);
                });
    }

    @PatchMapping("/flats/{id}/price/{newPrice}")
    public Flat updatePrice(@PathVariable double newPrice, @PathVariable Long id) throws FlatNotFoundException
    {
        return repo.findById(id)
                .map(flat -> {
                    flat.setPrice(newPrice);
                    return repo.save(flat);
                })
                .orElseThrow(FlatNotFoundException::new);

    }

    @DeleteMapping("/flats/{id}")
    void deleteFlat(@PathVariable Long id) {
        repo.deleteById(id);
    }

}
