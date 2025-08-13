/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appdieta;

/**
 *
 * @author rafae
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Atividades {
    
    private final Map<String, Double>atividadesCadastradas;
    

    public Atividades() {
        atividadesCadastradas = new HashMap<>();
        carregarAtividades(); 
    }

    private void carregarAtividades() {
        try (BufferedReader br = new BufferedReader(new FileReader("atividades.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String nomeAtividade = partes[0];
                    double met = Double.parseDouble(partes[1]);
                    atividadesCadastradas.put(nomeAtividade, met);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    
    }

public void adicionarAtividade(String nomeAtividade, double met) throws Exception {
    if(atividadesCadastradas.containsKey(nomeAtividade)){
        throw new Exception("Atividade ja cadastrada!");
    } 
    if (met < 0){
        throw new Exception("O valor do MET não pode ser negativo:");
    }
    atividadesCadastradas.put(nomeAtividade, met);
    }

public void removerAtividade(String nomeAtividade)throws Exception{
 
   if(atividadesCadastradas.containsKey(nomeAtividade)) {
     atividadesCadastradas.remove(nomeAtividade);
 } else{
       throw new Exception("Atividade nao cadastrada,nao eh possivel remover!");
   }}
public void mostrarAtividade()throws Exception{
    if(atividadesCadastradas.isEmpty()){
       throw new Exception("Nao existe atividade cadastrada"); 
    } else{   
        for (Map.Entry<String, Double> entry : atividadesCadastradas.entrySet()) {
            String nomeAtividade = entry.getKey();
            double m = entry.getValue();
            System.out.println(nomeAtividade + ": " + m + " minutos");
        }
    }
}
}