package ma.atos.reclamation.Service;

import ma.atos.reclamation.Models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    public abstract List<Client> findAll() ;
    public abstract Client update(long id , Client c);
    public abstract Optional<Client> findById(Long id);
    public abstract void deleteById(long id);



}
