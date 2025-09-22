package com.examplo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.examplo.app.model.Produto;
import com.examplo.app.service.ProdutoService;

import lombok.AllArgsConstructor;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/produtos")
public class ProdutoController {
    
    @Autowired
    private final ProdutoService produtoService;

    @GetMapping(path = "/all")
    public ResponseEntity <List<Produto>> listarProdutos()
    {
        
       List <Produto> produtos =produtoService.listarTodosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}
