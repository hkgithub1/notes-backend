package net.hkapp.notes.services.contracts;

import net.hkapp.notes.entity.Client;
import net.hkapp.notes.entity.Note;

import java.util.List;

public interface ClientService {
    void createClient(Client newClient);
    Client findClientById(Integer clientId);
    void updateClient(Client clientUpdates);
    void deleteClient(Integer clientId);
    List<Client> getAllClients();
}
