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
    public Client add(Client client) {
        return clientRepository.save(client);

    }

    @Override
    public Client update(long thirdPartyNumber, Client client) {
        client.setThirdPartyNumber(thirdPartyNumber);
        return clientRepository.save(client);

    }

    @Override
    public void deleteById(long thirdPartyNumber) {
        clientRepository.deleteById(thirdPartyNumber);

    }

    @Override
    public Optional<Client> findById(Long thirdPartyNumber) {
        return clientRepository.findById(thirdPartyNumber);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();

    }





}
