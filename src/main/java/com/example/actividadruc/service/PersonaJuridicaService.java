package com.example.actividadruc.service;

import com.example.actividadruc.entity.PersonaJuridicaEntity;

public interface PersonaJuridicaService {
    PersonaJuridicaEntity guardarPersonaJuridica(String ruc);
    PersonaJuridicaEntity obtenerPorId(Long id);
    PersonaJuridicaEntity actualizarPersonaJuridica(Long id, PersonaJuridicaEntity juridico);
}
