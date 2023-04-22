package br.unipar.TrabalhoPimeiroBimestre;

import javax.swing.JOptionPane;
import java.util.Random;
import br.unipar.TrabalhoPimeiroBimestre.model.*;

public class Main {

    public static void main(String[] args) {
        //Esse trabalho usa os conceitos de herança aprendidos dentro da matéria de Programação Orientada a Objetos. As classes "OrdenacaoSelecao", "OrdenacaoInsercao" e "OrdenacaoBolhs"
        //São herdeiras da classe "MetodoOrdenacao", que contem atributos e metodos utilizados dentro de todas as classes de Ordenações que herdam da mesma.
        
        //O projeto também utiliza a opção de OptionDialog do JOptionPane para mostrar botões com nomes respectivos a determinadas escolhas que o usuário pode vir a tomar dentro da aplicação
        //Para que esses botões tenham devida personalização, se dá necessário criar um vetor do tipo String com todas as opções que se deseja ter dentro do JOptionPane.
        
        //Além disso é utilizado o pacote "util" do java para fazer a importação de Random, para que o vetor possa ser populado com com números aleatórios
        
        //A criação dos objetos para fazer a ordenação do vetor foi colocada em metodos dentro da classe main, e são acessados dentro do código para fazer dita ordenação.
        
        //O código foi comentado para uma melhor leitura e interpretação do mesmo.
        
        
        //Resultados obtidos: O Metodo de ordenação bolha é o mais demorado entre os 3, após isso, o de seleção e o mais rápido sendo o de inserção. Esses resultados são mais perceptiveis
        //quando feitos em listas maiores, já que o tempo para roda-lás é maior. Tornando suas diferenças mais evidentes.
        

        //Declaração do vetor "vetor" como um vetor de números
        int[] vetor;
        
        //Perguntar como o usuário quer popular o vetor
        String[] popularOpcoes = {"Manualmente", "Automaticamente"};
        int escolhaPopular = JOptionPane.showOptionDialog(null, "Como deseja popular o vetor:",
                "Popular o vetor",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, popularOpcoes, popularOpcoes[1]);
        
        
        
        //Pedir tamanho do vetor
        int qtd = inserirNum("Quantas casas terá o vetor:");
        vetor = new int[qtd];
        
        
        int conteudo;
        //Caso o usuário queira preencher automaticamente
        if(escolhaPopular == 1){
            //Uso de random para gerar um número aléatorio e popular o vetor
            Random r = new Random();
            
            for(int pos = 0; pos < qtd; pos++){
                conteudo = r.nextInt(0,1000);
                vetor[pos] = conteudo;
            }
        }
        
        //Caso o usuário queira preencher manualmente
        else{
            for(int pos = 0; pos < qtd; pos++){
                conteudo = inserirNum("Insira um número para colocar na posição ["+ pos +"] do vetor:");
                vetor[pos] = conteudo;
            }
        }
        
        //Mostrar o vetor para o usuário
            //Criando string com as posições e valores dentro do vetor
        String output = "";
        for(int i =0; i < vetor.length; i++){
            output += "vetor[" + i + "] = "+ vetor[i] + "\n";
        }
        
            //Mostrando a string
        System.out.println(output);
        JOptionPane.showMessageDialog(null, "Vetor populado!\n Cheque o console para ve-lo.");
        
        
        
        //Pedir metodo de ordencação
        String[] opcoesMetodo = {"Inserção", "Seleção", "Bolha"};
        int escolhaMetodo = JOptionPane.showOptionDialog(null, "Com qual metodo deseja organizar o vetor:",
                "Metodo de organização",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMetodo, opcoesMetodo[0]);
        

            //Inserção
            if(escolhaMetodo == 0)
                metodoInsercao(vetor);
              
            //Seleção
            else if(escolhaMetodo == 1)
                metodoSelecao(vetor);
                
            //Bolha
            else
                metodoBolha(vetor);
        
        
        //Pedir se o usuário quer comparar resultados
        String[] opcoesComparar = {"Sim", "Não"};
        int escolhaComparar = JOptionPane.showOptionDialog(null, "Deseja comparar o resultado com outros metodos de organização?",
                "Escolher se quer comparar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesComparar, opcoesComparar[1]);
        
        //Se quiser
        if(escolhaComparar == 0){
            System.out.println("\n\n--------------------------------------------\n");
            metodoInsercao(vetor);
            System.out.println("\n--------------------------------------------\n");
            metodoSelecao(vetor);
            System.out.println("\n--------------------------------------------\n");
            metodoBolha(vetor);
            
            JOptionPane.showMessageDialog(null, "Comparação Realizada! Tudo sobre eles pode ser visto no console.");
        }
        
        //Fim do projeto
    }
    
    //Validar e facilitar preenchimento
    private static int inserirNum(String msg){
        String num;
        while (true) {
            num = JOptionPane.showInputDialog(msg);
            
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Esse não é um número válido!\nTente denovo.");
            }
        }
    }
    
    
    //Metodos para fazer a organização e printar
    
    private static void metodoInsercao(int[] vetor){
        //Criando o objeto do metodo de ordenação e populando seus atributos
        OrdenacaoInsercao insercao = new OrdenacaoInsercao();
        insercao.setVetor(vetor.clone());
        insercao.ordenarVetor(vetor.clone());
        

        System.out.println(insercao.toString());
        
        //Mostrar vetor ordenado para o usuário
        JOptionPane.showMessageDialog(null, "Vetor organizado com o metodo de insercao! cheque o console.\nTempo de execução: "+ insercao.getTempoExecucao() +" ms");
    }
    
    private static void metodoSelecao(int[] vetor){
        //Criando o objeto do metodo de ordenação e populando seus atributos
        OrdencaoSelecao selecao = new OrdencaoSelecao();
        selecao.setVetor(vetor.clone());
        selecao.ordenarVetor(vetor.clone());

        System.out.println(selecao.toString());
        
        //Mostrar vetor ordenado para o usuário
        JOptionPane.showMessageDialog(null, "Vetor organizado com o metodo de selecao! cheque o console.\nTempo de execução: "+ selecao.getTempoExecucao() +" ms");
    }
    
    private static void metodoBolha(int[] vetor){
        //Criando o objeto do metodo de ordenação e populando seus atributos
        OrdencaoBolha bolha = new OrdencaoBolha();
        bolha.setVetor(vetor.clone());
        bolha.ordenarVetor(vetor.clone());

        System.out.println(bolha.toString());
        
        //Mostrar vetor ordenado para o usuário
        JOptionPane.showMessageDialog(null, "Vetor organizado com o metodo bolha! cheque o console.\nTempo de execução: "+ bolha.getTempoExecucao() +" ms");
    }
    
}


