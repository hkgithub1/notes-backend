package net.hkapp.notes.services;

import io.micrometer.common.util.StringUtils;
import net.hkapp.notes.dao.ClientDao;
import net.hkapp.notes.entity.Client;
import net.hkapp.notes.services.contracts.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public void createClient(Client newClient) {
        clientDao.save(newClient);
        System.out.println("Record Created Successfully");
    }

    @Override
    public Client findClientById(Integer clientId) {
        Client result = null;
        Optional<Client> opt = clientDao.findById(clientId);
        if(opt.isPresent()) {
            result = opt.get();
        }
        return result;
    }

    @Override
    public void updateClient(Client clientUpdates) {
        Client result = null;
        Optional<Client> opt = clientDao.findById(clientUpdates.getClientId());
        if (opt.isPresent()) {
            result = opt.get();
            if (StringUtils.isNotEmpty(clientUpdates.getFirstName())) {
                result.setFirstName(clientUpdates.getFirstName());
            }
            if (StringUtils.isNotEmpty(clientUpdates.getLastName())) {
                result.setLastName(clientUpdates.getLastName());
            }
            if (StringUtils.isNotEmpty(clientUpdates.getStreetAddress())) {
                result.setStreetAddress(clientUpdates.getStreetAddress());
            }
            if (StringUtils.isNotEmpty(clientUpdates.getCity())) {
                result.setCity(clientUpdates.getCity());
            }
            if (StringUtils.isNotEmpty(clientUpdates.getState())) {
                result.setState(clientUpdates.getState());
            }
            if (StringUtils.isNotEmpty(clientUpdates.getFirstName())) {
                result.setState(clientUpdates.getState());
            }
            clientDao.save(result);

        } else {
            System.out.println("Record not found");
        }
    }

    @Override
    public void deleteClient(Integer clientId) {
        clientDao.deleteById(clientId);
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> results = clientDao.findAll();
        return results;
    }
}
