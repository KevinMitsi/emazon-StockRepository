package com.kevin.emazon.infraestructure.controllers;

import com.kevin.emazon.application.dto.ItemDto;
import com.kevin.emazon.application.dto.response.ItemResponseDto;
import com.kevin.emazon.application.handler.IItemHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    private final IItemHandler itemHandler;
    @PostMapping("/new")
    public ResponseEntity<String> createItem(@RequestBody ItemDto itemDto){
        itemHandler.saveItem(itemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item creado correctamente "+ itemDto.getName());
    }

    @GetMapping("/getAll/byBrand/{name}/{order}")
    public ResponseEntity<List<ItemResponseDto>> getAllByBrandName(@PathVariable String name, @PathVariable String order){
        return ResponseEntity.status(HttpStatus.OK).body(itemHandler.getAllByBrandName(name, order).getContent());
    }
    @GetMapping("/getAll/byCategory/{name}/{order}")
    public ResponseEntity<List<ItemResponseDto>> getAllByCategoryName(@PathVariable String name, @PathVariable String order){
        return ResponseEntity.status(HttpStatus.OK).body(itemHandler.getAllByCategoryName(name, order).getContent());
    }
    @GetMapping("/getAll/byName/{name}/{order}")
    public ResponseEntity<List<ItemResponseDto>> getAllByName(@PathVariable String name, @PathVariable String order){
        return ResponseEntity.status(HttpStatus.OK).body(itemHandler.getAllByName(name, order).getContent());
    }
}
