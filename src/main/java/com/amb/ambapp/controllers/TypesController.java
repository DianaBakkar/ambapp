package com.amb.ambapp.controllers;



import com.amb.ambapp.modules.Types;
import com.amb.ambapp.services.TypesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/types")
public class TypesController {

    private TypesService typesService;
    public TypesController(TypesService typesService) {
        this.typesService = typesService;
    }
    @PostMapping
    public void registerNewType(@RequestBody Types types) {
        typesService.addNewType(types);
    }
    @DeleteMapping(path = "{id}")
    public void deleteType(@PathVariable("id") int id) {
        typesService.deleteType(id);
    }
    @GetMapping
    public List<Types> getTypes() {
        return typesService.getTypes();
    }
    @PutMapping(path = "{id}")
    public void updateTypes(@PathVariable("id") int id, @RequestParam(required = false) String label) {
        typesService.updateType(id,label);
    }




}
