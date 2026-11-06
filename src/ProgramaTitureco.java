import java.util.List;
import java.util.Scanner;

public class ProgramaTitureco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Instancia a interface utilizando a implementação em List
        TiturecoInterface sistema = new TiturecoList();

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- MENU TITURECO ---");
            System.out.println("1 - Cadastrar Atrativo");
            System.out.println("2 - Pesquisar Atrativos da Cidade");
            System.out.println("3 - Listar Todos os Atrativos");
            System.out.println("4 - Apagar Atrativo");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n-- Cadastrando Novo Atrativo --");
                    System.out.print("É uma praia? (S/N): ");
                    boolean isPraia = scanner.nextLine().trim().equalsIgnoreCase("S");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Latitude (ex: -7.1150): ");
                    double lat = Double.parseDouble(scanner.nextLine());
                    System.out.print("Longitude (ex: -34.8631): ");
                    double lon = Double.parseDouble(scanner.nextLine());
                    System.out.print("Como chegar: ");
                    String comoChegar = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();

                    AtrativoTuristico novoAtrativo;

                    if (isPraia) {
                        System.out.print("É própria para banho? (S/N): ");
                        boolean propriaParaBanho = scanner.nextLine().trim().equalsIgnoreCase("S");
                        System.out.print("Tem perigo de tubarão? (S/N): ");
                        boolean perigoTubarao = scanner.nextLine().trim().equalsIgnoreCase("S");
                        System.out.print("Tipo de orla (Piscinas Naturais/Ondas Fortes/Ondas Médias): ");
                        String tipoOrla = scanner.nextLine();

                        novoAtrativo = new Praia(nome, lat, lon, comoChegar, cidade, estado, propriaParaBanho, perigoTubarao, tipoOrla);
                    } else {
                        novoAtrativo = new AtrativoTuristico(nome, lat, lon, comoChegar, cidade, estado);
                    }

                    if (sistema.cadastrarAtrativo(novoAtrativo)) {
                        System.out.println("=> Atrativo cadastrado com sucesso!");
                    } else {
                        System.out.println("=> Falha ao cadastrar: Atrativo já existe no sistema.");
                    }
                    break;

                case 2:
                    System.out.println("\n-- Pesquisar Atrativos --");
                    System.out.print("Digite a Cidade: ");
                    String cidadeBusca = scanner.nextLine();
                    System.out.print("Digite o Estado: ");
                    String estadoBusca = scanner.nextLine();

                    List<AtrativoTuristico> encontrados = sistema.pesquisaAtrativosDaCidade(cidadeBusca, estadoBusca);
                    if (encontrados.isEmpty()) {
                        System.out.println("=> Nenhum atrativo encontrado para esta localidade.");
                    } else {
                        System.out.println("=> Atrativos encontrados:");
                        for (AtrativoTuristico a : encontrados) {
                            String tipo = (a instanceof Praia) ? "[Praia]" : "[Geral]";
                            System.out.println("- " + tipo + " " + a.getNome());
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n-- Lista de Todos os Atrativos --");
                    List<AtrativoTuristico> todos = sistema.getAtrativos();
                    if (todos.isEmpty()) {
                        System.out.println("=> Nenhum atrativo cadastrado no sistema.");
                    } else {
                        for (AtrativoTuristico a : todos) {
                            String tipo = (a instanceof Praia) ? "[Praia]" : "[Geral]";
                            System.out.println("- " + tipo + " " + a.getNome() + " (" + a.getCidade() + "/" + a.getEstado() + ")");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n-- Apagar Atrativo --");
                    System.out.print("Nome do Atrativo: ");
                    String nomeApagar = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeApagar = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estadoApagar = scanner.nextLine();

                    if (sistema.apagarAtrativo(nomeApagar, cidadeApagar, estadoApagar)) {
                        System.out.println("=> Atrativo removido com sucesso!");
                    } else {
                        System.out.println("=> Atrativo não encontrado. Verifique se os dados estão corretos.");
                    }
                    break;

                case 5:
                    System.out.println("Encerrando o sistema Titureco...");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha um número de 1 a 5.");
            }
        }
        scanner.close();
    }
}