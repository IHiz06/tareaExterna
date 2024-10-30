package com.example.actividadruc.controller;

import com.example.actividadruc.entity.PersonaJuridicaEntity;
import com.example.actividadruc.service.PersonaJuridicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/personaJuridica")
public class PersonaJuridicaController {
    private final PersonaJuridicaService personaJuridicaService;

    public PersonaJuridicaController(PersonaJuridicaService personaJuridicaService) {
        this.personaJuridicaService = personaJuridicaService;
    }
    @PostMapping
    public ResponseEntity<PersonaJuridicaEntity> guardarPersonaJuridica(@RequestParam("ruc") String ruc){
        PersonaJuridicaEntity personaJuridica = personaJuridicaService.guardarPersonaJuridica(ruc);
        if (personaJuridica == null) {
            // Retornamos NOT_FOUND si no se pudo obtener la información de la API externa
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personaJuridica, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPersonaJuridica(@PathVariable Long id, @RequestBody PersonaJuridicaEntity juridico) {
        PersonaJuridicaEntity personaActualizada = personaJuridicaService.actualizarPersonaJuridica(id, juridico);
        if (personaActualizada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Registro no encontrado con el ID proporcionado.");
        }
        return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
    }
}
