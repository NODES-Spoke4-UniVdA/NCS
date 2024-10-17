package com.example.nodes.service;

import com.example.nodes.entity.Interest;
import com.example.nodes.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestService {

    @Autowired
    private InterestRepository interestRepository;

    public List<Interest> findAllInterests() {
        return interestRepository.findAll();
    }

    // Additional interest-related business logic can be added here
}