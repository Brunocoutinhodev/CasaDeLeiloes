/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
   public void cadastrarProduto (ProdutosDTO produto){
        
        // 1. Abre a conexão usando a sua classe conectaDAO
        conn = new conectaDAO().connectDB();
        
        // 2. Prepara o comando SQL de inserção
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        
        try {
            prep = conn.prepareStatement(sql);
            
            // 3. Pega os valores do objeto DTO e coloca no comando SQL
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor()); 
            prep.setString(3, produto.getStatus());
            
            // 4. Executa o comando no banco de dados
            prep.executeUpdate();
            
            // 5. Exibe a mensagem de sucesso (Exigência da atividade!)
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (Exception e) {
            // Se algo der errado (ex: banco desligado), exibe o erro
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

