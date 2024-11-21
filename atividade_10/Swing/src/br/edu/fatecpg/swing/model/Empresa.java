package br.edu.fatecpg.swing.model;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class Empresa {
    private Cliente[] clientes = new Cliente[5];
    private Funcionario[] funcionarios = new Funcionario[10];
    private int totalClientes = 0;
    private int totalFuncionarios = 0;

    public void adicionarCliente(String nome, String email) {
        if (totalClientes < clientes.length) {
            clientes[totalClientes++] = new Cliente(nome, email);
        } else {
            JOptionPane.showMessageDialog(null, "Limite de clientes atingido.");
        }
    }

    public String mostrarClientes() {
        StringBuilder sb = new StringBuilder("Clientes cadastrados:\n");
        for (int i = 0; i < totalClientes; i++) {
            sb.append("Nome: ").append(clientes[i].getNome())
              .append(", Email: ").append(clientes[i].getEmail())
              .append("\n");
        }
        return sb.toString();
    }

    public void adicionarFuncionario(String nome, String cargo, double salario) {
        if (totalFuncionarios < funcionarios.length) {
            funcionarios[totalFuncionarios++] = new Funcionario(nome, cargo, salario);
        } else {
            JOptionPane.showMessageDialog(null, "Limite de funcionários atingido.");
        }
    }

    public String mostrarFuncionarios() {
        StringBuilder sb = new StringBuilder("Funcionários cadastrados:\n");
        for (int i = 0; i < totalFuncionarios; i++) {
            sb.append("Nome: ").append(funcionarios[i].getNome())
              .append(", Cargo: ").append(funcionarios[i].getCargo())
              .append(", Salário: ").append(funcionarios[i].getSalario())
              .append("\n");
        }
        return sb.toString();
    }

    public double calcularFolhaSalarial() {
        double total = 0;
        for (int i = 0; i < totalFuncionarios; i++) {
            total += funcionarios[i].getSalario();
        }
        return total;
    }

    public double calcularMediaSalarial() {
        if (totalFuncionarios == 0) return 0;

        Calculadora calculadora = new Calculadora();
        double somaSalarios = Arrays.stream(funcionarios, 0, totalFuncionarios)
                                    .mapToDouble(Funcionario::getSalario)
                                    .sum();
        return calculadora.multiplicacao(somaSalarios, 1.0 / totalFuncionarios);
    }

    public String exibirMediaSalarial() {
        return "Média Salarial: " + calcularMediaSalarial();
    }

    // Novo método para remover um cliente (exemplo de modificação)
    public void removerCliente(String nome) {
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i].getNome().equals(nome)) {
                // Move todos os clientes para a esquerda
                System.arraycopy(clientes, i + 1, clientes, i, totalClientes - i - 1);
                clientes[--totalClientes] = null; // Ajusta o contador e limpa a referência
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
    }
}
