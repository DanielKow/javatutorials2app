package me.daniel.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatRepo extends CrudRepository<Flat, Long> {
    List<Flat> findByCity(String city);
}
