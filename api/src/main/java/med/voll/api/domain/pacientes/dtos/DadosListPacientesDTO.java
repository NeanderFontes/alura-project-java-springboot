package med.voll.api.domain.pacientes.dtos;

import med.voll.api.domain.pacientes.models.PacientesModel;

public record DadosListPacientesDTO(
        Long id,
        String nome,
        String email,
        String cpf) {

    public DadosListPacientesDTO(PacientesModel pacientesModel) {
        this(pacientesModel.getId(), pacientesModel.getNome(), pacientesModel.getEmail(), pacientesModel.getCpf());
    }
}
