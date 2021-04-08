package ma.atos.reclamation.services;

import ma.atos.reclamation.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    public Client add(Client client);

    public  Client update(long thirdPartyNumber, Client client);

    public  void deleteById(long thirdPartyNumber);

    public  Optional<Client> findById(Long thirdPartyNumber);

    public  List<Client> findAll();


}
