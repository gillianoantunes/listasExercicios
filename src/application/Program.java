package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionarios;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantos funcionários deseja cadastrar?");
		int n = sc.nextInt();
		//cria a lista do tipo clase Funcionarios
        List<Funcionarios> lista = new  ArrayList<>();
       
		for (int i = 0; i < n; i++) {
			System.out.println("Digite o Id do funcionario:");
			Integer id = sc.nextInt();
			System.out.println("Digite o nome do funcionario:");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Digite o salário do funcionario:");
			Double salario = sc.nextDouble();
			// alimenta o objeto func com os dados
			 Funcionarios func = new Funcionarios(id, nome, salario);
			//adiciona na lista
			 lista.add(func);
		}
		
		System.out.println("Entre com o id do funcionário que deseja aumentar o salário:");
		Integer idaumento = sc.nextInt();
		
		System.out.println("Entre com a porcentagem:");
		Double valor = sc.nextDouble();
		
		//percorre a lista criada e verifica o id igual 
		//e chama afuncao aumentarSalario da classe Funcionarios
		int verificaSeEncontrou = -1;
		for (Funcionarios x : lista) {
			if(idaumento == x.getId()) {
				x.aumentarSalario(valor);
				verificaSeEncontrou = 1;
			}					
		}
		if (verificaSeEncontrou == -1) {
			System.out.println("Id não encontrado");
		}
		System.out.printf("Lista de Funcionários: %n");
		// Percorre e imprime a lista
		for (Funcionarios x : lista) {
			System.out.println(x.getId() +", "+ x.getNome() +", "+
					x.getSalario() );
		}

		sc.close();

	}

}
