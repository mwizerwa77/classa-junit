package com.example.classajunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.classajunit.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	boolean existsByName(String name);

}
