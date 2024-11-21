package br.edu.fatecpg.swing.view;

import br.edu.fatecpg.swing.model.Empresa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;
    private Empresa empresa = new Empresa();

    public Main() {
        setTitle("Sistema de Gestão de Empresa");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JButton btnAdicionarCliente = new JButton("Adicionar Cliente");
        JButton btnMostrarClientes = new JButton("Mostrar Clientes");
        JButton btnAdicionarFuncionario = new JButton("Adicionar Funcionário");
        JButton btnMostrarFuncionarios = new JButton("Mostrar Funcionários");
        JButton btnExibirFolhaSalarial = new JButton("Folha Salarial");
        JButton btnExibirMediaSalarial = new JButton("Média Salarial");
        JButton btnRemoverCliente = new JButton("Remover Cliente");

        btnAdicionarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Cliente:");
                if (nome != null && !nome.trim().isEmpty()) {
                    String email = JOptionPane.showInputDialog("Email do Cliente:");
                    if (email != null && !email.trim().isEmpty()) {
                        empresa.adicionarCliente(nome, email);
                    } else {
                        JOptionPane.showMessageDialog(null, "Email não pode ser vazio.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome não pode ser vazio.");
                }
            }
        });

        btnMostrarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, empresa.mostrarClientes());
            }
        });

        btnAdicionarFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Funcionário:");
                if (nome != null && !nome.trim().isEmpty()) {
                    String cargo = JOptionPane.showInputDialog("Cargo do Funcionário:");
                    if (cargo != null && !cargo.trim().isEmpty()) {
                        try {
                            double salario = Double.parseDouble(JOptionPane.showInputDialog("Salário do Funcionário:"));
                            empresa.adicionarFuncionario(nome, cargo, salario);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Salário inválido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cargo não pode ser vazio.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome não pode ser vazio.");
                }
            }
        });

        btnMostrarFuncionarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, empresa.mostrarFuncionarios());
            }
        });

        btnExibirFolhaSalarial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Total da Folha Salarial: " + empresa.calcularFolhaSalarial());
            }
        });

        btnExibirMediaSalarial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, empresa.exibirMediaSalarial());
            }
        });

        btnRemoverCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = JOptionPane.showInputDialog("Nome do Cliente a Remover:");
                if (nomeCliente != null && !nomeCliente.trim().isEmpty()) {
                    empresa.removerCliente(nomeCliente);
                } else {
                    JOptionPane.showMessageDialog(null, "Nome não pode ser vazio.");
                }
            }
        });

        add(btnAdicionarCliente);
        add(btnMostrarClientes);
        add(btnAdicionarFuncionario);
        add(btnMostrarFuncionarios);
        add(btnExibirFolhaSalarial);
        add(btnExibirMediaSalarial);
        add(btnRemoverCliente);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
