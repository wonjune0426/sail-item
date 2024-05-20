package com.sparta.sailitem.repository;

import com.sparta.sailitem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
