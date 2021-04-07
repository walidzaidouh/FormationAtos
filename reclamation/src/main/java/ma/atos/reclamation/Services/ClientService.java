package ma.atos.reclamation.Services;

import ma.atos.reclamation.Models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    public Client add(Client client);

    public  Client update(long thirdPartyNumber, Client client);

    public  void deleteById(long thirdPartyNumber);

    public  Optional<Client> findById(Long thirdPartyNumber);

    public  List<Client> findAll();


}
