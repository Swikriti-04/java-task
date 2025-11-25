package com.example.cartservice.controller;

import com.example.userservice.model.Cart;
import com.example.userservice.model.CartItem;
import com.example.userservice.model.CreateCartRequest;
import com.example.userservice.model.AddItemRequest;
import com.example.userservice.model.UpdateItemRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final Map<String, Cart> carts = new HashMap<>();

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody(required = false) CreateCartRequest request) {
        String id = UUID.randomUUID().toString();

        Cart cart = new Cart();
        cart.setId(id);
        cart.setOwner(request != null ? request.getOwner() : "Guest");
        cart.setItems(new ArrayList<>());
        cart.setTotal(0.0);

        carts.put(id, cart);

        return ResponseEntity.status(201).body(cart);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable String cartId) {
        Cart cart = carts.get(cartId);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String cartId) {
        carts.remove(cartId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<Cart> addItem(@PathVariable String cartId,
                                        @RequestBody AddItemRequest request) {

        Cart cart = carts.get(cartId);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }

        CartItem item = new CartItem();
        item.setId(UUID.randomUUID().toString());
        item.setProductId(request.getProductId());
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        item.setQuantity(request.getQuantity());

        cart.getItems().add(item);

        updateTotal(cart);

        return ResponseEntity.ok(cart);
    }

    @PutMapping("/{cartId}/items")
    public ResponseEntity<Cart> updateItem(@PathVariable String cartId,
                                           @RequestBody UpdateItemRequest request) {

        Cart cart = carts.get(cartId);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }

        Optional<CartItem> itemOpt = cart.getItems().stream()
                .filter(i -> i.getId().equals(request.getItemId()))
                .findFirst();

        if (itemOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CartItem item = itemOpt.get();
        item.setQuantity(request.getQuantity());

        updateTotal(cart);

        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<Cart> removeItem(@PathVariable String cartId,
                                           @PathVariable String itemId) {

        Cart cart = carts.get(cartId);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }

        boolean removed = cart.getItems().removeIf(i -> i.getId().equals(itemId));

        if (!removed) {
            return ResponseEntity.notFound().build();
        }

        updateTotal(cart);

        return ResponseEntity.ok(cart);
    }

    private void updateTotal(Cart cart) {
        double total = cart.getItems().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
        cart.setTotal(total);
    }
}
