package com.kevin.emazon.infraestructure.adapter;

import com.kevin.emazon.domain.model.Item;
import com.kevin.emazon.domain.api.IItemServicePort;

import java.util.Optional;

public class IItemJpaAdapter implements IItemServicePort {
    @Override
    public Iterable<Item> getItems() {
        return null;
    }

    @Override
    public Optional<Item> getItem(Long id) {
        return Optional.empty();
    }

    @Override
    public Item saveItem(Item item) {
        return null;
    }

    @Override
    public void deleteItem(Long id) {

    }
}
