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
import jakarta.validation.constraints.NotNull;
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
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.PoslasticarnicaDto;
import rs.ac.bg.fon.si.njt.njt_projekat.servis.PoslasticarnicaServis;

/**
 *
 * @author Mila
 */

@RestController
//omogucava CRUD op.
//svaki http zahtev koji dolazi sa klijenta na serversku stranu izmedju ostalih parametara ima link
//kako controller zna za koje linkove je on zaduzen?
@RequestMapping("/api/poslasticarnica")
//svi zahtevi koji dodju proveri da li zapocinju sa ovim, ako zapocinju onda je ovaj controller zaduzen za to
public class PoslasticarnicaController {
    
    private final PoslasticarnicaServis poslServis;

    public PoslasticarnicaController(PoslasticarnicaServis poslServis) {
        this.poslServis = poslServis;
    }
    
    @GetMapping //("/{id}")
    //objasnjenje sta metoda radi, korisno za generisanje automatske dokumentacije
    @Operation(summary = "Retrieve all Poslasticarnica entities.")
    //dodatne info, content je heder
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(
                implementation = PoslasticarnicaDto.class), 
                mediaType = "application/json")
    })
    //server vraca klijentu, u sebi ima listu posldto objekata
    public ResponseEntity<List<PoslasticarnicaDto>> getAll(){
        return new ResponseEntity<>(poslServis.findAll(),
                HttpStatus.OK);
    }
    
    //ne mozemo da imamo dve metode koje imaju istu rutu
    @GetMapping("/{id}")
    public ResponseEntity<PoslasticarnicaDto> getById(
        @NotNull(message = "Should not be null or empty.")
        @PathVariable(value = "id") Long id) {
        //prima parametar Long id koji ima anotaciju da ne sme da bude null i da ce se taj parametar
        //zvati id, zapravo je to iz naseg linka taj id
        try {
            return new ResponseEntity<>(poslServis.findById(id),
                HttpStatus.OK);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                    "PoslasticarnicaController exception: "+ex.getMessage());
        }
    }
    
    @PostMapping
    @Operation(summary = "Create a new Poslasticarnica entities.")
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(
                implementation = PoslasticarnicaDto.class), 
                mediaType = "application/json")
    })
    public ResponseEntity<PoslasticarnicaDto> addPoslasticarnica(
            @Valid @RequestBody @NotNull PoslasticarnicaDto poslDto){
        //svaki http zahtev ima heder link metodu body...
        //iz body parametra treba da izvucemo podatke o posl koju treba da kreiramo
        //prvo validiramo body param, izvlacimo body iz celog reaquesta ne sme da bude null 
        //i kroz body param cemo poslati json obj gde ce biti podaci o restoranu
        //i on ce automatski znaci da treba da ga prevede u dto obj
        try {
        System.out.println(poslDto);
        PoslasticarnicaDto saved = poslServis.create(poslDto);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                    "Error while saving poslasticarnica: "+ex.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        try{
            poslServis.deleteById(id);
            return new ResponseEntity<>("Poslasticarnica successfully deleted.", HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>("Poslasticarnica does not exist: "+id, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing Poslasticarnica entities.")
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(
                implementation = PoslasticarnicaDto.class), 
                mediaType = "application/json")
    })
    public ResponseEntity<PoslasticarnicaDto> updatePoslasticarnica(
            @PathVariable Long id, //izvlaci id iz linka
            @Valid @RequestBody PoslasticarnicaDto poslDto){ //uzima body validira i pretvori u poslDto obj
        try {
            poslDto.setId(id); //Osiguramo da se azurira pravi entitet
            PoslasticarnicaDto updated = poslServis.update(poslDto);
        return new ResponseEntity<>(updated,HttpStatus.OK);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                    "Error while updating poslasticarnica: "+ex.getMessage());
        }
    }
    
}
