package med.voll.api.pacientes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.models.EnderecoModel;
import med.voll.api.pacientes.dtos.DadosCadastroPacientesDTO;
import med.voll.api.pacientes.dtos.DadosToUpdatePacientesDTO;

@Entity(name = "Pacientes")
@Table(name = "pacientes")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacientesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private EnderecoModel endereco;

    public PacientesModel(DadosCadastroPacientesDTO dadosPacientesDTO) {
        this.nome = dadosPacientesDTO.nome();
        this.email = dadosPacientesDTO.email();
        this.telefone = dadosPacientesDTO.telefone();
        this.cpf = dadosPacientesDTO.cpf();
        this.endereco = new EnderecoModel(dadosPacientesDTO.endereco());
    }

    public void updateDadosPacientes(DadosToUpdatePacientesDTO dadosUpdatePacientes) {
        if (dadosUpdatePacientes.nome() != null) {
            this.nome = dadosUpdatePacientes.nome();
        }

        if (dadosUpdatePacientes.telefone() != null) {
            this.telefone = dadosUpdatePacientes.telefone();
        }

        if (dadosUpdatePacientes.endereco() != null) {
            this.endereco.updateInfoEndereco(dadosUpdatePacientes.endereco());
        }
    }
}
