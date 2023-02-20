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

    public Long findSockId(String color, int cottonPart) {
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
        Long idForAdd = findSockId(color, cottonPart);
        if (idForAdd == null) {
            addNewSock(color, cottonPart, numbersOfSocks);
        } else {
            addNumberOfSocks(idForAdd, numbersOfSocks);
        }
    }

    public boolean removeSocks(String color, int cottonPart, int numbersOfSocks) {
        Optional<Sock> sockForRemove = sockRepository.findByColorAndCottonPart(color, cottonPart);
        if (sockForRemove.isEmpty()) {
            return false;
        } else if (sockForRemove.get().getNumberOfSocks() < numbersOfSocks) {
            return false;
        } else {
            Sock remove = sockForRemove.get();
            remove.setNumberOfSocks(remove.getNumberOfSocks() - numbersOfSocks);
            sockRepository.save(remove);
            return true;
        }
    }

    public int getMoreThatCottonPart(String color, int cottonPart) {

        return sockRepository.findAll().stream()
                .filter(s -> s.getColor().equals(color))
                .filter(s -> s.getCottonPart() > cottonPart)
                .mapToInt(s -> s.getNumberOfSocks())
                .sum();
    }

    public int getLessThatCottonPart(String color, int cottonPart) {
        return sockRepository.findAll().stream()
                .filter(s -> s.getColor().equals(color))
                .filter(s -> s.getCottonPart() < cottonPart)
                .mapToInt(s -> s.getNumberOfSocks())
                .sum();
    }

    public int getEqualsCottonPart(String color, int cottonPart) {
        return sockRepository.findAll().stream()
                .filter(s -> s.getColor().equals(color))
                .filter(s -> s.getCottonPart() == cottonPart)
                .mapToInt(s -> s.getNumberOfSocks())
                .sum();
    }
}
