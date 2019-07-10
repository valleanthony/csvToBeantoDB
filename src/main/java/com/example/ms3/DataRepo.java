package com.example.ms3;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DataRepo extends CrudRepository<Data,Integer> {

    Optional<Data> findById (Integer id);
}
