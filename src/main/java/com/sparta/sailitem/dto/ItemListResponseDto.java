package com.sparta.sailitem.dto;

import com.sparta.sailitem.entity.Item;
import lombok.Getter;

@Getter
public class ItemListResponseDto {
    private Long id;
    private String title;
    private int price;
    private String username;

    public ItemListResponseDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.price = item.getPrice();
        this.username = item.getUsername();
    }
}
