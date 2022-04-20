package com.tp1.projet1.service;

import com.tp1.projet1.modele.Approvisionnement;
import com.tp1.projet1.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class approvisionnementService {
    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;

    public List<Approvisionnement>  showApprovisionnement(){
        return approvisionnementRepository.findAll();
    }

    public void saveApprovisionnement(Approvisionnement approvisionnement){
        approvisionnementRepository.save(approvisionnement);
    }

    public Approvisionnement showOneApprovisionnement(int id){
        return approvisionnementRepository.findById(id).get();
    }
    public void deleteApprovisionnement(int id){
        approvisionnementRepository.deleteById(id);
    }
}
