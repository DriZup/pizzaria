package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoDTO;
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

    public PedidoDTO criarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);

        Cliente cliente = clienteRepository
                .findById(pedido.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return new PedidoDTO(cliente.getNome(), cliente.getEmail(), pedido.getDescricao());
    }

    public List<PedidoDTO> listarPedidos() {
        return pedidoRepository.findAll().stream().map(pedido -> {
            Cliente cliente = clienteRepository
                    .findById(pedido.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

            return new PedidoDTO(cliente.getNome(), cliente.getEmail(), pedido.getDescricao());
        }).collect(Collectors.toList());
    }
}

