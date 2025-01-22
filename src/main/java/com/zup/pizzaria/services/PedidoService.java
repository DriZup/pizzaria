package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.exceptions.ClienteInvalidoException;
import com.zup.pizzaria.exceptions.PedidoNotFoundException;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<PedidoDTO> listarPedidos() {
        return pedidoRepository.findAll().stream()
                .map(PedidoDTO::new)
                .collect(Collectors.toList());
    }

    public PedidoDTO atualizarPedido(Long id, Pedido pedidoAtualizado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setDescricao(pedidoAtualizado.getDescricao());

        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return new PedidoDTO(pedidoSalvo);
    }

    public void deletarPedido(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new PedidoNotFoundException("Pedido não encontrado com o ID: " + id);
        }
        pedidoRepository.deleteById(id);
    }

    public PedidoDTO criarPedido(Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new ClienteInvalidoException("Cliente não encontrado com o ID: " + pedido.getCliente().getId()));
        pedido.setCliente(cliente);

        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return new PedidoDTO(pedidoSalvo);
    }
}