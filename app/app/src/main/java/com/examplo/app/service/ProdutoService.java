package com.examplo.app.service;
import com.examplo.app.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import com.examplo.app.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {
    @Autowired
    private final ProdutoRepository produtoRepository;

    public List<Produto> listarTodosProdutos(){
        return (List<Produto>) produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorID(Long id){
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void excluirProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Produto não encontrado com o ID = %id", id)));
        produto.setNome(produtoAtualizado.getNome());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setPreco(produtoAtualizado.getPreco());

        return produtoRepository.save(produto);
    }
}
