package br.unipar.ex2.listas.models;

import javax.swing.JOptionPane;

public class Banco {
    private Fila filaPrioritaria;
    private Fila filaNormal;
    private int atendimentoPriorizadoConsecutivo = 0;

    public Banco(int qtdNormal, int qtdPrioritaria) {
        this.filaPrioritaria = new Fila(qtdPrioritaria);
        this.filaNormal = new Fila(qtdNormal);
    }

    
    public boolean verificarPrioridade(Cliente cliente) {
        return 2023 - cliente.getAnoNascimento() > 65;
    }
    
    public void atender() {
        Cliente clienteAtendido = null;
        
        if(atendimentoPriorizadoConsecutivo >= 2 || filaPrioritaria.isEmpty()) {
            if(! filaNormal.isEmpty()) {
                clienteAtendido = filaNormal.dequeue();
            }
            
        atendimentoPriorizadoConsecutivo = 0;
        } else{
            if(! filaPrioritaria.isEmpty()) {
                clienteAtendido = filaPrioritaria.dequeue();
                atendimentoPriorizadoConsecutivo++;
            }
        }
        
        if(clienteAtendido != null)
            JOptionPane.showMessageDialog(null, "O cliente " + clienteAtendido.toString() + " foi atendido!");
        else
            JOptionPane.showMessageDialog(null, "Ninguem está na fila no momento. Logo, ninguem foi atendido.");
    }
    
    public void adicionar(Cliente novoCliente) {
        if(verificarPrioridade(novoCliente)) {
            novoCliente.setSenha("P" + filaPrioritaria.getQtdItens());
            
            if(! filaPrioritaria.isFull())
                filaPrioritaria.enqueue(novoCliente);
            else
                JOptionPane.showMessageDialog(null, "A fila prioritária está cheia, por favor atenda alguem primeiro");
            
        } else {
            novoCliente.setSenha("N" + filaNormal.getQtdItens());
            
            if(! filaNormal.isFull())
                filaNormal.enqueue(novoCliente);
            else
                JOptionPane.showMessageDialog(null, "A fila normal está cheia, por favor atenda alguem primeiro");
        }
    }
     
    public Fila getFilaPrioritaria() {
        return filaPrioritaria;
    }

    public void setFilaPrioritaria(Fila filaPrioritaria) {
        this.filaPrioritaria = filaPrioritaria;
    }

    public Fila getFilaNormal() {
        return filaNormal;
    }

    public void setFilaNormal(Fila filaNormal) {
        this.filaNormal = filaNormal;
    }

    public int getAtendimentoPriorizadoConsecutivo() {
        return atendimentoPriorizadoConsecutivo;
    }

    public void setAtendimentoPriorizadoConsecutivo(int atendimentoPriorizadoConsecutivo) {
        this.atendimentoPriorizadoConsecutivo = atendimentoPriorizadoConsecutivo;
    }

    @Override
    public String toString() {
        return "Banco{" + "filaPrioritaria=" + filaPrioritaria + ", filaNormal=" + filaNormal + '}';
    }
    
}
