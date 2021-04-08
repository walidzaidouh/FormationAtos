package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.models.Client;

public class ClientConverter {

    public ClientDTO entityToDTO(Client client){
        ClientDTO clientDto = new ClientDTO();
        clientDto.setCin(client.getCin());
        clientDto.setPpm(client.getPpm());
        clientDto.setAccountNumber(client.getAccountNumber());
        return clientDto;
    }


}
