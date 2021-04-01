package ma.atos.reclamation.Service;

import ma.atos.reclamation.Models.Reclamation;
import ma.atos.reclamation.Repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationServiceImpl implements ReclamationService{
    @Autowired
    private ReclamationRepository reclamationRepository;

    @Override
    public Reclamation add(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation update(String reference, Reclamation _reclamation) {
        return reclamationRepository.findById(reference)
                .map(reclamation -> {
                    reclamation.setPriority(_reclamation.getPriority());
                    reclamation.setDate(_reclamation.getDate());
                    reclamation.setGestionnaire(_reclamation.getGestionnaire());
                    reclamation.setBody(_reclamation.getBody());
                    return reclamationRepository.save(reclamation);
                })
                .orElseGet(() -> {
                    _reclamation.setReference(reference);
                    return reclamationRepository.save(_reclamation);
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
        return (List<Reclamation>) reclamationRepository.findAll();
    }
}
