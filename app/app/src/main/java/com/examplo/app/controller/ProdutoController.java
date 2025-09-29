package com.examplo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.examplo.app.model.Produto;
import com.examplo.app.service.ProdutoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity <Produto> buscarProdutoPorId(@PathVariable Long id ){
        Optional <Produto> produto = produtoService.buscarProdutoPorID(id);
        if(produto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@Valid @RequestBody Produto produto){
        Produto novoProduto = produtoService.salvarProduto(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
        try {
            Produto produto = produtoService.atualizarProduto(id, produtoAtualizado);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        produtoService.excluirProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
