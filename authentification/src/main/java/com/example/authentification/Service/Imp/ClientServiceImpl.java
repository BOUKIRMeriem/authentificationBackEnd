package com.example.authentification.Service.Imp;

import com.example.authentification.Entity.ClientEntity;
import com.example.authentification.Repository.ClientRepository;
import com.example.authentification.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<ClientEntity> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity add(ClientEntity client) {
        return clientRepository.save(client);
    }

    @Override
    public ClientEntity edit(ClientEntity clientEntity, int id) {
        ClientEntity client=clientRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Utilisateur non trouvé avec l'ID: " + id));
        client.setName(clientEntity.getName());
        client.setAdresse(clientEntity.getAdresse());
        client.setPhone(clientEntity.getPhone());
        return clientRepository.save(client);
    }

    @Override
    public ClientEntity delete(int id) {
        ClientEntity client=clientRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Utilisateur non trouvé avec l'ID: " + id));
        clientRepository.delete(client);
        return client;
    }

    @Override
    public ClientEntity getClientById(int id) {
        return clientRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Utilisateur non trouvé avec l'ID: " + id));
    }
}
