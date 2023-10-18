package br.edu.umfg.aula09102023;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();
    private Long idCounter = 1L;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        cliente.setId(Math.toIntExact(idCounter++));
        clientes.add(cliente);
        return cliente;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clientes;
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Integer id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

}
