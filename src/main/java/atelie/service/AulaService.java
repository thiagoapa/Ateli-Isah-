package atelie.service;

import atelie.model.Aula;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AulaService {
    private List<Aula> aulas = new ArrayList<>();
    private int nextId = 1;

    // CAMBIA LocalDateTime por String (más simple para la simulación)
    public void cadastrarAula(String tema, String dataHora, int vagasTotais) {
        Aula novaAula = new Aula(tema, dataHora, vagasTotais);
        novaAula.setIdAula(nextId++);
        this.aulas.add(novaAula);
        System.out.println("✅ Aula cadastrada: " + tema + " em " + dataHora);
    }

    public List<Aula> listarAulas() {
        return this.aulas;
    }

    public boolean agendarAula(int idAula, int idCliente) {
        for (Aula aula : aulas) {
            if (aula.getIdAula() == idAula) {
                if (aula.reservarVaga()) {
                    System.out.println("✅ Vaga reservada na aula " + idAula +
                            " para cliente " + idCliente);
                    return true;
                } else {
                    System.out.println("❌ Não há vagas disponíveis na aula " + idAula);
                    return false;
                }
            }
        }
        System.out.println("❌ Aula com ID " + idAula + " não encontrada");
        return false;
    }

    public boolean existemAulas() {
        return !aulas.isEmpty();
    }

    public Aula buscarAulaPorId(int id) {
        for (Aula a : aulas) {
            if (a.getIdAula() == id) {
                return a;
            }
        }
        return null;
    }
}