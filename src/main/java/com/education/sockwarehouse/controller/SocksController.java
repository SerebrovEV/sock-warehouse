package com.education.sockwarehouse.controller;

import com.education.sockwarehouse.model.EntrySocks;
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
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.status(HttpStatus.OK.value()).build();
    }
}
