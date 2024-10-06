package com.example.authentification.Controller;

import com.example.authentification.Entity.ClientEntity;
import com.example.authentification.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/client")
@RestController
public class ClientController {


    private final ClientService clientService;

    @GetMapping("/list")
    public List<ClientEntity> getAll(){
        return clientService.getAll();
    }
    @PostMapping("/add")
    public ClientEntity save(@RequestBody ClientEntity client){
        return clientService.add(client);
    }
    @PutMapping("/edit/{id}")
    public ClientEntity edit(@RequestBody  ClientEntity client,@PathVariable  int id){
        return clientService.edit(client,id);
    }
    @DeleteMapping("/delete/{id}")
    public ClientEntity delete(@PathVariable int id){
        return clientService.delete(id);
    }
    @GetMapping("/{id}")
    public ClientEntity getById(@PathVariable int id){
        return clientService.getClientById(id);
    }
}
