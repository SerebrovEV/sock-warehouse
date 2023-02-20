package com.education.sockwarehouse.controller;

import com.education.sockwarehouse.model.EntrySocks;
import com.education.sockwarehouse.model.Sock;
import com.education.sockwarehouse.service.EntrySocksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("socks")
public class SocksController {

    private final EntrySocksService entrySocksService;

    public SocksController(EntrySocksService entrySocksService) {
        this.entrySocksService = entrySocksService;
    }

    @PostMapping("/income")
    public ResponseEntity incomeSocks(@RequestBody EntrySocks entrySocks) {
        boolean addSocks = entrySocksService.addSocks(entrySocks);
        if (addSocks) {
            return ResponseEntity.ok().build();
        } else if (!addSocks) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/outcome")
    public ResponseEntity outcomeSocks(@RequestBody EntrySocks entrySocks) {
        boolean removeSocks = entrySocksService.removeSocks(entrySocks);
        if (removeSocks) {
            return ResponseEntity.ok().build();
        } else if (!removeSocks) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity getSocks(@RequestParam(name = "color") String color,
                                   @RequestParam(name = "operation") String operation,
                                   @RequestParam(name = "cottonPart") int cottonPart) {
        if (!(operation.equals("moreThan") || operation.equals("lessThan") || operation.equals("equal")) || cottonPart < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        int pairOfSocks = entrySocksService.getSocks(color, operation, cottonPart);
        return ResponseEntity.ok(pairOfSocks);
    }

}
