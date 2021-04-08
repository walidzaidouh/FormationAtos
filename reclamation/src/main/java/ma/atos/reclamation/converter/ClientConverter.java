package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.models.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientConverter{

    public ClientDTO FromClientToClientDto(Client client){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(client, ClientDTO.class);
    }

    public Client FromClientDtoToClient(ClientDTO clientDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(clientDTO, Client.class);
    }

    public List<ClientDTO> FromListClientsToListClientsDto(List<Client> clients){
        ModelMapper mapper =new ModelMapper();
        return clients.stream().map(this::FromClientToClientDto).collect(Collectors.toList());
    }

    public List<Client> FromListClientsDtoToListClients(List<ClientDTO> clientsDto){
        ModelMapper mapper =new ModelMapper();
        return clientsDto.stream().map(this::FromClientDtoToClient).collect(Collectors.toList());

    }

}
