import java.util.Scanner;

public class ReservaCinema {

  public static void verAssentos(int[][] matriz) {
    // String mostrando o significado dos assentos
    System.out.println("""

        MENU DE ASSENTOS DO CINEMA

        0 -> Livre
        1 -> Ocupado

        """);

    System.out.print("      ");
    for (int j = 0; j < matriz[0].length; j++) {
      System.out.print((j + 1) + "   ");
    }
    System.out.println();
    // Mostrando os assentos
    for (int i = 0; i < matriz.length; i++) {
      char letraLinha = (char) ('A' + i);
      System.out.print(letraLinha + "     ");
      for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + "   ");
      }
      System.out.println();
    }
  }

  public static void reservarAssento(int[][] matriz, int coluna, String linha) {
    // Escolher um assento para reservar
    int indiceLinha = linha.toUpperCase().charAt(0) - 'A';
    int indiceColuna = coluna - 1;

    if (indiceLinha < 0 || indiceLinha >= matriz.length || indiceColuna < 0 || indiceColuna >= matriz[0].length) {
      System.out.println("Assento inválido");
    }

    if (matriz[indiceLinha][indiceColuna] == 1) {
      System.out.println("Esse assento já está reservado!!");
    } else {
      matriz[indiceLinha][indiceColuna] = 1;
      System.out.println("Assento reservado com sucesso.");
    }

  }

  public static void cancelarReserva(int[][] matriz, int coluna, String linha) {
    int indiceLinha = linha.toUpperCase().charAt(0) - 'A';
    int indiceColuna = coluna - 1;

    if (indiceLinha < 0 || indiceLinha >= matriz.length || indiceColuna < 0 || indiceColuna >= matriz[0].length) {
      System.out.println("Assento inválido");
    }

    if (matriz[indiceLinha][indiceColuna] == 0) {
      System.out.println("Esse assento não está reservado!!");
    } else {
      matriz[indiceLinha][indiceColuna] = 0;
      System.out.println("Reserva cancelada com sucesso.");
    }
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    // Criando matriz de assentos do cinema
    int[][] cinema = new int[5][5];

    System.out.print("""
          BEM VINDO AO CINEMA, ESCOLHA A MELHOR OPÇÃO          
        """);

    int opcao = -1;

    while (opcao != 0) {

      // Menu de seleção
      String menu = """
          \n1. Ver todos os assentos;
          2. Reserva de assentos;
          3. Cancelar reserva;
          0. Sair
          """;

      System.out.println(menu);
      opcao = scan.nextInt();

      switch (opcao) {
        case 1:
          verAssentos(cinema);
          break;
        case 2:
          verAssentos(cinema);
          System.out.println("Escolha a coluna onde está seu assento (1 - 5): ");
          int coluna = scan.nextInt();
          System.out.println("Escolha a linha onde está seu assento (A - E): ");
          String linha = scan.next();
          System.out.println("Você escolheu o assento " + linha + coluna + "?");
          System.out.println("Digite 1 para sim, e 0 para não");
          int escolha = scan.nextInt();
          if (escolha == 1) {
            reservarAssento(cinema, coluna, linha);
          } else {
            System.out.println("Assento inválido!");
          }
          break;
        case 3:
          verAssentos(cinema);
          System.out.println("Escolha a coluna onde está seu assento (1 - 5): ");
          int colunaCancelamento = scan.nextInt();
          System.out.println("Escolha a linha onde está seu assento (A - E): ");
          String linhaCanelamento = scan.next();
          System.out.println("Você quer cancelar o assento " + linhaCanelamento + colunaCancelamento + "?");
          System.out.println("Digite 1 para sim, e 0 para não");
          int escolhaCancelamento = scan.nextInt();
          if (escolhaCancelamento == 1) {
            cancelarReserva(cinema, colunaCancelamento, linhaCanelamento);
          } else {
            System.out.println("Assento inválido!");
          }
          break;
        case 0:
          System.out.println("Programa encerrado!");
          opcao = 0;
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }
    }
    scan.close();
  }
}
