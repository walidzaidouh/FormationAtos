package ma.atos.reclamation.Service;

import ma.atos.reclamation.Models.Client;
import ma.atos.reclamation.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();

    }

    @Override
    public Client update(long id, Client c) {
        c.setId(id);
        return clientRepository.save(c);

    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        clientRepository.deleteById(id);

    }

}
