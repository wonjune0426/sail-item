package com.sparta.sailitem.service;

import com.sparta.sailitem.dto.ItemListResponseDto;
import com.sparta.sailitem.dto.ItemRequestDto;
import com.sparta.sailitem.dto.ItemResponseDto;
import com.sparta.sailitem.dto.ResponseMessage;
import com.sparta.sailitem.entity.Item;
import com.sparta.sailitem.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item item = new Item(requestDto);
        itemRepository.save(item);
        return new ItemResponseDto(item);
    }

    public List<ItemListResponseDto> getItems() {
        return itemRepository.findAll().stream().map(ItemListResponseDto::new).toList();
    }

    @Transactional
    public ItemResponseDto updateItem(Long id, ItemRequestDto requestDto) {
        Item item = findItem(id);
        item.update(requestDto);
        ItemResponseDto responseDto = new ItemResponseDto(item);
        return responseDto;
    }

    public ResponseMessage deleteItem(Long id) {
        Item item = findItem(id);
        itemRepository.delete(item);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMsg("삭제완료");
        return responseMessage;
    }

    private Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 item은 존재하지 않습니다.")
        );
    }
}
