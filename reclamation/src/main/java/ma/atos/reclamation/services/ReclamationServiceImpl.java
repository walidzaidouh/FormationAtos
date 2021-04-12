package ma.atos.reclamation.services;

import ma.atos.reclamation.models.Reclamation;
import ma.atos.reclamation.repositories.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationServiceImpl implements ReclamationService {
    @Autowired
    private ReclamationRepository reclamationRepository;

    @Override
    public Reclamation add(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation update(String reference, Reclamation reclamation) {
        return reclamationRepository.findById(reference)
                .map(reclamationTemp -> {
                    reclamationTemp.setPriority(reclamationTemp.getPriority());
                    reclamationTemp.setDate(reclamationTemp.getDate());
                    reclamationTemp.setGestionnaire(reclamationTemp.getGestionnaire());
                    reclamationTemp.setBody(reclamationTemp.getBody());
                    return reclamationRepository.save(reclamationTemp);
                })
                .orElseGet(() -> {
                    reclamation.setReference(reference);
                    return reclamationRepository.save(reclamation);
                });
    }

    @Override
    public void deleteById(String reference) {
        reclamationRepository.deleteById(reference);
    }

    @Override
    public Optional<Reclamation> findById(String reference) {
        return reclamationRepository.findById(reference);
    }

    @Override
    public List<Reclamation> findAll() {
        return reclamationRepository.findAll();
    }
}
