package com.example.authentification.Service;

import com.example.authentification.Entity.ClientEntity;

import java.util.List;

public interface ClientService {
    List<ClientEntity> getAll();
    ClientEntity add(ClientEntity client);
    ClientEntity edit(ClientEntity client,int id);
    ClientEntity delete(int id);
    ClientEntity getClientById(int id);


}
