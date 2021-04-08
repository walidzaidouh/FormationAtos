package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.models.Client;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class ClientConverter{

    public ClientDTO ClientToClientDto(Client client){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(client, ClientDTO.class);
    }

    public Client ClientDtoToClient(ClientDTO clientDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(clientDTO, Client.class);
    }

    public List<ClientDTO> ListClientsToListClientsDto(List<Client> clients){
        ModelMapper mapper =new ModelMapper();
        return clients.stream().map(this::ClientToClientDto).collect(Collectors.toList());
    }

    public List<Client> ListClientsDtoToListClients(List<ClientDTO> clientsDto){
        ModelMapper mapper =new ModelMapper();
        return clientsDto.stream().map(this::ClientDtoToClient).collect(Collectors.toList());

    }

}
