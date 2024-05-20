package com.sparta.sailitem.controller;

import com.sparta.sailitem.dto.ItemListResponseDto;
import com.sparta.sailitem.dto.ItemRequestDto;
import com.sparta.sailitem.dto.ItemResponseDto;
import com.sparta.sailitem.dto.ResponseMessage;
import com.sparta.sailitem.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
        return itemService.createItem(requestDto);
    }

    @GetMapping("/post")
    public List<ItemListResponseDto> getItems() {
        return itemService.getItems();
    }

    @PutMapping("/post/{id}")
    public ItemResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
        return itemService.updateItem(id,requestDto);
    }

    @DeleteMapping("/post/{id}")
    public ResponseMessage deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}
