package com.anemchenko.core.controllers;

import com.anemchenko.api.dtos.OrderDetailsDto;
import com.anemchenko.api.dtos.OrderDto;
import com.anemchenko.core.services.OrderService;
import com.anemchenko.core.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final Converter converter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDetailsDto orderDetailsDto, Principal principal) {
        orderService.createOrder(principal, orderDetailsDto);
    }

    @GetMapping
    public List<OrderDto> getOrdersForCurrentUser(Principal principal) {

        return orderService.findAllByUsername(principal.getName()).stream().map(o -> converter.orderToDto(o)).collect(Collectors.toList());
    }
}
