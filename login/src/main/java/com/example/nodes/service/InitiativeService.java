package com.example.nodes.service;

import com.example.nodes.entity.Initiative;
import com.example.nodes.repository.InitiativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitiativeService {

    @Autowired
    private InitiativeRepository initiativeRepository;

    public Initiative saveInitiative(Initiative initiative) {
        return initiativeRepository.save(initiative);
    }
}