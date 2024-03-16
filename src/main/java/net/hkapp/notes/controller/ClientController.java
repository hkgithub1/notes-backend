package net.hkapp.notes.controller;

import net.hkapp.notes.entity.Client;
import net.hkapp.notes.services.contracts.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/backend/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/create-client", produces = "application/json")
    public void createClient(@RequestBody Client newClient) {
        clientService.createClient(newClient);
    }

    @GetMapping(value = "/find-client-by-id/{clientId}", produces = "application/json")
    public Client findClientById(@PathVariable Integer clientId) {
        return clientService.findClientById(clientId);
    }

    @PutMapping(value = "/update-client", produces = "application/json")
    public void updateClient(@RequestBody Client clientUpdates) {
        clientService.updateClient(clientUpdates);
    }

    @DeleteMapping(value = "/delete-client/{clientId}", produces = "application/json")
    public void deleteEmployee(@PathVariable Integer clientId) {
        clientService.deleteClient(clientId);
    }

    @GetMapping(value = "/get-all-clients", produces = "application/json")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

}
