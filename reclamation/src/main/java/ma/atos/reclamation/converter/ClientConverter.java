package ma.atos.reclamation.converter;

import ma.atos.reclamation.dto.ClientDTO;
import ma.atos.reclamation.models.Client;
import org.modelmapper.ModelMapper;

public class ClientConverter {

    public ClientDTO entityToDTO(Client client){
        /* ClientDTO clientDto = new ClientDTO();
        clientDto.setCin(client.getCin());
        clientDto.setPpm(client.getPpm());
        clientDto.setAccountNumber(client.getAccountNumber());*/

        ModelMapper mapper =new ModelMapper();
        return mapper.map(client, ClientDTO.class);

    }


}
