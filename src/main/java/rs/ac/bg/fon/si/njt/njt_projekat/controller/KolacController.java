/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.KolacDto;
import rs.ac.bg.fon.si.njt.njt_projekat.servis.KolacServis;

/**
 *
 * @author Mila
 */

@RestController
@RequestMapping("/api/kolac")
public class KolacController {
    
    private final KolacServis kolacServis;

    public KolacController(KolacServis kolacServis) {
        this.kolacServis = kolacServis;
    }
    
    @GetMapping
    @Operation(summary = "Retrieve all Kolac entities.")
    public ResponseEntity<List<KolacDto>> getAll(){
        return new ResponseEntity<>(kolacServis.findAll(),
                HttpStatus.OK);
    }
    
    @PostMapping
    @Operation(summary = "Create a new Kolac entities.")
    public ResponseEntity<KolacDto> addKolac(
            @Valid @RequestBody KolacDto kolacDto){
        try {
        KolacDto saved =kolacServis.create(kolacDto);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                    "Error while saving kolac: "+ex.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        try{
            kolacServis.deleteById(id);
            return new ResponseEntity<>("Kolac successfully deleted.", HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>("Kolac does not exist: "+id, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing Kolac entities.")
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(
                implementation = KolacDto.class), 
                mediaType = "application/json")
    })
    public ResponseEntity<KolacDto> updateKolac(
            @PathVariable Long id, 
            @Valid @RequestBody KolacDto kolacDto){ 
        try {
            kolacDto.setId(id); 
            KolacDto updated = kolacServis.update(kolacDto);
        return new ResponseEntity<>(updated,HttpStatus.OK);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                    "Error while updating kolac: "+ex.getMessage());
        }
    }
}
