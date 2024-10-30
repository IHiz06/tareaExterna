package com.example.actividadruc.service.impl;

import com.example.actividadruc.aggregates.constants.Constants;
import com.example.actividadruc.aggregates.response.ResponseSunat;
import com.example.actividadruc.client.ClientSunat;
import com.example.actividadruc.entity.PersonaJuridicaEntity;
import com.example.actividadruc.repository.PersonaJuridicaRepository;
import com.example.actividadruc.service.PersonaJuridicaService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class PersonaJuridicaServiceImpl implements PersonaJuridicaService {

    private final PersonaJuridicaRepository personaJuridicaRepository;
    private final ClientSunat clientSunat;

    public PersonaJuridicaServiceImpl(PersonaJuridicaRepository personaJuridicaRepository, ClientSunat clientSunat) {
        this.personaJuridicaRepository = personaJuridicaRepository;
        this.clientSunat = clientSunat;
    }

    @Value("${token.api}")
    private String token;

    @Override
    public PersonaJuridicaEntity guardarPersonaJuridica(String ruc) {
        PersonaJuridicaEntity personaJuridica = getEntity(ruc);
        if(Objects.nonNull(personaJuridica)){
            return personaJuridicaRepository.save(personaJuridica);
        } else {
            return null;
        }
    }

    @Override
    public PersonaJuridicaEntity obtenerPorId(Long id) {
        return personaJuridicaRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Persona Jurídica con ID " + id + " no encontrada."));
    }


    @Override
    public PersonaJuridicaEntity actualizarPersonaJuridica(Long id, PersonaJuridicaEntity juridico) {
        PersonaJuridicaEntity personaJuridicaExistente = obtenerPorId(id);
        // Actualizar los campos necesarios
        personaJuridicaExistente.setRazonSocial(juridico.getRazonSocial());
        personaJuridicaExistente.setTipoDocumento(juridico.getTipoDocumento());
        personaJuridicaExistente.setNumeroDocumento(juridico.getNumeroDocumento());
        personaJuridicaExistente.setEstado(juridico.getEstado());
        personaJuridicaExistente.setCondicion(juridico.getCondicion());
        personaJuridicaExistente.setDireccion(juridico.getDireccion());
        personaJuridicaExistente.setUbigeo(juridico.getUbigeo());
        personaJuridicaExistente.setViaTipo(juridico.getViaTipo());
        personaJuridicaExistente.setViaNombre(juridico.getViaNombre());
        personaJuridicaExistente.setZonaCodigo(juridico.getZonaCodigo());
        personaJuridicaExistente.setZonaTipo(juridico.getZonaTipo());
        personaJuridicaExistente.setNumero(juridico.getNumero());
        personaJuridicaExistente.setInterior(juridico.getInterior());
        personaJuridicaExistente.setLote(juridico.getLote());
        personaJuridicaExistente.setDpto(juridico.getDpto());
        personaJuridicaExistente.setManzana(juridico.getManzana());
        personaJuridicaExistente.setKilometro(juridico.getKilometro());
        personaJuridicaExistente.setDistrito(juridico.getDistrito());
        personaJuridicaExistente.setProvincia(juridico.getProvincia());
        personaJuridicaExistente.setDepartamento(juridico.getDepartamento());
        personaJuridicaExistente.setEsAgenteRetencion(juridico.isEsAgenteRetencion());
        personaJuridicaExistente.setTipo(juridico.getTipo());
        personaJuridicaExistente.setActividadEconomica(juridico.getActividadEconomica());
        personaJuridicaExistente.setNumeroTrabajadores(juridico.getNumeroTrabajadores());
        personaJuridicaExistente.setTipoFacturacion(juridico.getTipoFacturacion());
        personaJuridicaExistente.setTipoContabilidad(juridico.getTipoContabilidad());
        personaJuridicaExistente.setComercioExterior(juridico.getComercioExterior());
        personaJuridicaExistente.setUserUpdate(Constants.USER_UPDATE);
        personaJuridicaExistente.setDateUpdate(new Timestamp(System.currentTimeMillis()));

        return personaJuridicaRepository.save(personaJuridicaExistente);

    }



    private PersonaJuridicaEntity getEntity(String ruc){
        PersonaJuridicaEntity personaJuridicaEntity = new PersonaJuridicaEntity();
        ResponseSunat datosreniecj = executionSunatJ(ruc);
        if(Objects.nonNull(datosreniecj)){
            personaJuridicaEntity.setRazonSocial(datosreniecj.getRazonSocial());
            personaJuridicaEntity.setTipoDocumento(datosreniecj.getTipoDocumento());
            personaJuridicaEntity.setNumeroDocumento(datosreniecj.getNumeroDocumento());
            personaJuridicaEntity.setEstado(datosreniecj.getEstado());
            personaJuridicaEntity.setCondicion(datosreniecj.getCondicion());
            personaJuridicaEntity.setDireccion(datosreniecj.getDireccion());
            personaJuridicaEntity.setUbigeo(datosreniecj.getUbigeo());
            personaJuridicaEntity.setViaTipo(datosreniecj.getViaTipo());
            personaJuridicaEntity.setViaNombre(datosreniecj.getViaNombre());
            personaJuridicaEntity.setZonaCodigo(datosreniecj.getZonaCodigo());
            personaJuridicaEntity.setZonaTipo(datosreniecj.getZonaTipo());
            personaJuridicaEntity.setNumero(datosreniecj.getNumero());
            personaJuridicaEntity.setInterior(datosreniecj.getInterior());
            personaJuridicaEntity.setLote(datosreniecj.getLote());
            personaJuridicaEntity.setDpto(datosreniecj.getDpto());
            personaJuridicaEntity.setManzana(datosreniecj.getManzana());
            personaJuridicaEntity.setKilometro(datosreniecj.getKilometro());
            personaJuridicaEntity.setDistrito(datosreniecj.getDistrito());
            personaJuridicaEntity.setProvincia(datosreniecj.getProvincia());
            personaJuridicaEntity.setDepartamento(datosreniecj.getDepartamento());
            personaJuridicaEntity.setEsAgenteRetencion(datosreniecj.isEsAgenteRetencion());
            personaJuridicaEntity.setTipo(datosreniecj.getTipo());
            personaJuridicaEntity.setActividadEconomica(datosreniecj.getActividadEconomica());
            personaJuridicaEntity.setNumeroTrabajadores(datosreniecj.getNumeroTrabajadores());
            personaJuridicaEntity.setTipoFacturacion(datosreniecj.getTipoFacturacion());
            personaJuridicaEntity.setTipoContabilidad(datosreniecj.getTipoContabilidad());
            personaJuridicaEntity.setComercioExterior(datosreniecj.getComercioExterior());
            personaJuridicaEntity.setUserCreated(Constants.USER_CREATED);
            personaJuridicaEntity.setDateCreated(new Timestamp(System.currentTimeMillis()));
            personaJuridicaEntity.setUserUpdate(Constants.USER_CREATED);
            personaJuridicaEntity.setDateUpdate(new Timestamp(System.currentTimeMillis()));
        }
        return personaJuridicaEntity;
    }

    private ResponseSunat executionSunatJ(String ruc){
        String tokenO = Constants.BEARER + token;
        try {
            return clientSunat.getPersonaJuridicaReniec(ruc, tokenO);
        } catch (FeignException e) {
            System.err.println("Error en la API externa: " + e.getMessage());
            return null;
        }
    }
}
