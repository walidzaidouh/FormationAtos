package ma.atos.reclamation.converter;

import ma.atos.reclamation.DTO.ClientDTO;
import ma.atos.reclamation.Models.Client;

public class ClientConverter {

    public ClientDTO entityToDTO(Client client){
        ClientDTO clientDto = new ClientDTO();
        clientDto.setCin(client.getCin());
        clientDto.setPpm(client.getPpm());
        clientDto.setAccountNumber(client.getAccountNumber());
        return clientDto;
    }


}
