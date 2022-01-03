package com.amb.ambapp.services;

import com.amb.ambapp.modules.Types;
import com.amb.ambapp.repositories.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypesService {
    private TypesRepository typesRepository;
    @Autowired
    public TypesService(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }

    public List<Types> getTypes() {
        return typesRepository.findAll();
    }
    public void addNewType(Types type) {
        typesRepository.save(type);
    }
    public void deleteType(int Id) {
        Boolean TypeExists = typesRepository.existsById(Id);
        if (!TypeExists) {
            throw new IllegalStateException("Type with Id:" + Id + " does not exists");
        }
        typesRepository.deleteById(Id);
    }
    @Transactional
    public void updateType(int id, int newType) {
        Types type = typesRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Type with Id " + id + " does not exists"));
      if(!(type.getType()==newType)){
          type.setType(newType);
      }
    }



    }
