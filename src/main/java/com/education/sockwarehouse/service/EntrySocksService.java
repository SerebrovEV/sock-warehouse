package com.education.sockwarehouse.service;

import com.education.sockwarehouse.model.EntrySocks;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntrySocksService {

    private final SockService sockService;

    public boolean addSocks(EntrySocks entrySocks) {
        String color = entrySocks.getColor();
        int cottonPart = entrySocks.getCottonPart();
        int numbersOfSocks = entrySocks.getQuantity();
        if (color.isEmpty() || numbersOfSocks <= 0 || cottonPart < 0) {
            return false;
        } else {
            sockService.addSocks(color, cottonPart, numbersOfSocks);
            return true;
        }
    }

    public boolean removeSocks(EntrySocks entrySocks) {
        String color = entrySocks.getColor();
        int cottonPart = entrySocks.getCottonPart();
        int numbersOfSocks = entrySocks.getQuantity();
        if (color.isEmpty() || numbersOfSocks <= 0 || cottonPart < 0) {
            return false;
        } else {
            return sockService.removeSocks(color, cottonPart, numbersOfSocks);
        }
    }

    public int getSocks(String color, String operation, int cottonPart) {
        if(operation.equals("moreThan")){
           return sockService.getMoreThatCottonPart(color,cottonPart);
        }else if(operation.equals("lessThan")){
          return sockService.getLessThatCottonPart(color,cottonPart);
        }else {
            return sockService.getEqualsCottonPart(color,cottonPart);
        }
    }
}
