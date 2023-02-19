package com.education.sockwarehouse.service;

import com.education.sockwarehouse.model.Sock;
import com.education.sockwarehouse.repository.SockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SockService {
    private final SockRepository sockRepository;

    public Long findSock(String color, int cottonPart) {
        Optional<Sock> sock = sockRepository.findByColorAndCottonPart(color, cottonPart);
        return sock.map(Sock::getId).orElse(null);
    }

    private void addNewSock(String color, int cottonPart, int numberOfSocks) {
        sockRepository.save(new Sock(color, cottonPart, numberOfSocks));
    }

    private void addNumberOfSocks(long id, int numberOfSocks) {
        Sock newSocks = sockRepository.findById(id).get();
        newSocks.setNumberOfSocks(newSocks.getNumberOfSocks() + numberOfSocks);
        sockRepository.save(newSocks);
    }

    public void addSocks(String color, int cottonPart, int numbersOfSocks) {
        Long idForAdd = findSock(color, cottonPart);
        if (idForAdd == null) {
          addNewSock(color, cottonPart, numbersOfSocks);
        }else{
            addNumberOfSocks(idForAdd,numbersOfSocks);
        }
    }
}
