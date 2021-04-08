package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.models.Client;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientConverter {

    public ClientDTO ClientToClientDto(Client client){

        ModelMapper mapper =new ModelMapper();
        return mapper.map(client, ClientDTO.class);


    }

    public Client ClientDtoToClient(ClientDTO clientDTO){
        Client client

        ModelMapper mapper =new ModelMapper();
        return mapper.map(clientDTO, Client.class);
    }

    public List<ClientDTO> ListClientToListClientDto(List<Client> clients){
        ModelMapper mapper =new ModelMapper();
        Stream.of(clients).map(c, Client.class).collect(Collectors.toList());
     //   return mapper.map(ClientDTO, Client.class);
        return null;
    }

}
