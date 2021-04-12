package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.models.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientConverter{

    public ClientDTO fromClientToClientDto(Client client){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(client, ClientDTO.class);
    }

    public Client fromClientDtoToClient(ClientDTO clientDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(clientDTO, Client.class);
    }

    public List<ClientDTO> fromListClientsToListClientsDto(List<Client> clients){
        return clients.stream().map(this::fromClientToClientDto).collect(Collectors.toList());
    }

    public List<Client> fromListClientsDtoToListClients(List<ClientDTO> clientsDto){
        return clientsDto.stream().map(this::fromClientDtoToClient).collect(Collectors.toList());

    }

}
