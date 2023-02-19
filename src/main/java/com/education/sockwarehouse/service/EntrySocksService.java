package com.education.sockwarehouse.service;

import com.education.sockwarehouse.model.EntrySocks;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntrySocksService {

    private final SockService sockService;

    public boolean addSocks(EntrySocks entrySocks) {
        boolean addSocks = true;
        String color = entrySocks.getColor();
        int cottonPart = entrySocks.getCottonPart();
        int numbersOfSocks = entrySocks.getQuantity();
        if (color.isEmpty() || numbersOfSocks <= 0 || cottonPart < 0) {
            addSocks = false;
        } else {
            sockService.addSocks(color, cottonPart, numbersOfSocks);
        }
        return addSocks;
    }

}
