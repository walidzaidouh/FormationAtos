package ma.atos.reclamation.Services;

import ma.atos.reclamation.Models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    public abstract Client add(Client client);
    public abstract Client update(long thirdPartyNumber , Client client);
    public abstract void deleteById(long thirdPartyNumber);
    public abstract Optional<Client> findById(Long thirdPartyNumber);
    public abstract List<Client> findAll() ;



}
