package com.arthur.algafood.api.controller;


import com.arthur.algafood.domain.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pedidos/{codigoPedido}")
public class FluxoPedidoController {

    @Autowired
    private FluxoPedidoService fluxoPedido;

    @PutMapping("/confirmacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirmar(@PathVariable String codigoPedido) {
        fluxoPedido.confirmar(codigoPedido);
    }

    @PutMapping("/cancelamento")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelar(@PathVariable String codigoPedido) {
        fluxoPedido.cancelar(codigoPedido);
    }

    @PutMapping("/entrega")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void entregar(@PathVariable String codigoPedido) {
        fluxoPedido.entregar(codigoPedido);
    }

}
