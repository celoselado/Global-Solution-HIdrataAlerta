package br.com.climaconsciente.tests;

import br.com.climaconsciente.enums.NivelRisco;
import br.com.climaconsciente.models.EmergenciaGrave;
import br.com.climaconsciente.models.Temperatura;
import br.com.climaconsciente.models.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean sairProg = true;
        boolean nomeValido, bairroValido, opcaoValida;
        String nome, bairro;
        String[] numeros = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9"};

        System.out.println("\n--------------------------------");
        System.out.println("         CUIDAR CALOR          ");
        System.out.println("--------------------------------");

        // 1. Coleta de dados do usuario
        do {
            nomeValido = true;

            System.out.println("Digite o nome: ");
            nome = sc.nextLine();

            for(String numero : numeros){
                if(nome.contains(numero)){
                    System.out.println("O nome não deve conter números!");
                    nomeValido = false;
                    break;
                }
            }
        } while(!nomeValido);

        do {
            bairroValido = true;

            System.out.println("Digite o seu bairro: ");
            bairro = sc.nextLine();

            for(String numero : numeros){
                if(bairro.contains(numero)){
                    System.out.println("O bairro não deve conter números!");
                    bairroValido = false;
                    break;
                }
            }
        } while(!bairroValido);

        Usuario usuario = new Usuario(nome, bairro);

        do {

            // MENU
            System.out.println("--------------------------------------------------");
            System.out.println("O que você gostaria de ver no sistema? \n1- VER O RELÁTORIO DA TEMPERATURA ATUAL" +
                    "                                                  \n2- PERGUNTAS FREQUENTES SOBRE O CALOR" +
                    "                                                  \n3- PRÁTICAS ESSENCIAIS PARA ENFRENTAR ALTAS TEMPERATURAS" +
                    "                                                  \n4- SAIR DO PROGRAMA " +
                    "                                                  \n---------------------------------------------------------" +
                    "                                                  \nOPÇÃO: ");

            int opcao = 0;
            do {
                opcaoValida = true;

                System.out.println("Digite a opção: ");
                String escolha = sc.nextLine().trim();

                if (!escolha.matches("\\d+")) {
                    System.out.println("Digite apenas números!");
                    opcaoValida = false;
                } else {
                    opcao = Integer.parseInt(escolha);
                }

            } while (!opcaoValida);

            switch (opcao) {
                case 1:
                    System.out.println("---------------------------------");

                    double graus = 0;
                    boolean tempValida = false;
                    do {
                        System.out.print("Digite a temperatura atual: ");
                        if (sc.hasNextDouble()) {
                            graus = sc.nextDouble();
                            sc.nextLine(); // limpar buffer
                            tempValida = true;
                        } else {
                            System.out.println("Por favor, digite um número válido para a temperatura.");
                            sc.nextLine(); // limpar entrada inválida
                        }
                    } while (!tempValida);

                    Temperatura temperatura = new Temperatura(graus);

                    NivelRisco risco = temperatura.avaliarRisco();

                    EmergenciaGrave alerta = new EmergenciaGrave("Temperatura elevada", risco);

                    System.out.println("\n--- RELATÓRIO DE ALERTA ---");
                    System.out.println("Usuário: " + usuario.getNome());
                    System.out.println("Bairro: " + usuario.getBairro());
                    System.out.println("Temperatura: " + temperatura.exibirTemperatura(true));
                    System.out.println("Mensagem do Alerta: " + alerta.getMensagem());

                    System.out.println("\n---------------------------");
                    System.out.println("Deseja voltar ao menu? ");
                    System.out.println("1- SIM" +
                            "           \n2- NÃO");
                    System.out.println("---------------------------");

                    int opcaoVoltar1 = 0;
                    boolean voltarValido1 = false;
                    do {
                        if (sc.hasNextInt()) {
                            opcaoVoltar1 = sc.nextInt();
                            sc.nextLine(); // limpar buffer
                            if (opcaoVoltar1 == 1 || opcaoVoltar1 == 2) {
                                voltarValido1 = true;
                            } else {
                                System.out.println("Digite 1 para SIM ou 2 para NÃO.");
                            }
                        } else {
                            System.out.println("Digite apenas números!");
                            sc.nextLine(); // limpar entrada inválida
                        }
                    } while (!voltarValido1);

                    sairProg = (opcaoVoltar1 == 1);

                    break;

                case 2:
                    System.out.println(
                            "\n=== PERGUNTAS FREQUENTES: ONDAS DE CALOR EXTREMO ===\n" +
                                    "\n" +
                                    "1. O que é uma onda de calor?\n" +
                                    "Uma onda de calor ocorre quando a temperatura fica acima do normal por vários dias consecutivos.\n" +
                                    "\n" +
                                    "2. Quem são os mais vulneráveis ao calor extremo?\n" +
                                    "Bebês, crianças pequenas, idosos, mulheres grávidas e pessoas com doenças crônicas são mais suscetíveis aos efeitos do calor.\n" +
                                    "\n" +
                                    "3. Quais são os principais riscos à saúde?\n" +
                                    "O calor extremo pode causar desidratação, insolação, queda de pressão arterial, problemas cardiovasculares e até insuficiência renal.\n" +
                                    "\n" +
                                    "4. Como prevenir problemas de saúde durante uma onda de calor?\n" +
                                    "- Hidrate-se: Beba bastante água, mesmo sem sentir sede.\n" +
                                    "- Evite exposição ao sol: Especialmente entre 10h e 16h.\n" +
                                    "- Use roupas leves: Prefira tecidos como algodão.\n" +
                                    "- Cuide da alimentação: Consuma frutas ricas em água, como melancia e melão.\n" +
                                    "\n" +
                                    "5. Como proteger crianças e idosos?\n" +
                                    "- Ofereça água frequentemente, pois eles podem não perceber a sede.\n" +
                                    "- Evite atividades físicas intensas ao ar livre durante os horários mais quentes.\n" +
                                    "- Mantenha ambientes frescos e ventilados.\n" +
                                    "\n" +
                                    "6. O que fazer em caso de insolação?\n" +
                                    "Se alguém apresentar sintomas como tontura, pele quente e seca, confusão mental ou desmaio, leve a pessoa para um local fresco, ofereça líquidos e procure atendimento médico imediatamente."
                    );

                    System.out.println("\n---------------------------");
                    System.out.println("Deseja voltar ao menu? ");
                    System.out.println("1- SIM" +
                            "           \n2- NÃO");
                    System.out.println("---------------------------");

                    int opcaoVoltar2 = 0;
                    boolean voltarValido2 = false;
                    do {
                        if (sc.hasNextInt()) {
                            opcaoVoltar2 = sc.nextInt();
                            sc.nextLine(); // limpar buffer
                            if (opcaoVoltar2 == 1 || opcaoVoltar2 == 2) {
                                voltarValido2 = true;
                            } else {
                                System.out.println("Digite 1 para SIM ou 2 para NÃO.");
                            }
                        } else {
                            System.out.println("Digite apenas números!");
                            sc.nextLine(); // limpar entrada inválida
                        }
                    } while (!voltarValido2);

                    sairProg = (opcaoVoltar2 == 1);

                    break;

                case 3:
                    System.out.println(
                            "\n=== PRÁTICAS ESSENCIAIS DE SAÚDE E SEGURANÇA PARA ENFRENTAR ONDAS DE CALOR EXTREMO ===\n" +
                                    "\n" +
                                    "Proteção contra o calor\n" +
                                    "- Use roupas leves, de cores claras e confortáveis.\n" +
                                    "- Aplique protetor solar regularmente, cobrindo todas as áreas expostas.\n" +
                                    "- Use chapéus, óculos escuros e mantenha-se em locais frescos sempre que possível.\n" +
                                    "\n" +
                                    "Cuidados com crianças e idosos\n" +
                                    "- Ofereça água frequentemente, pois eles podem não perceber a sede.\n" +
                                    "- Mantenha ambientes bem ventilados ou climatizados.\n" +
                                    "- Evite atividades físicas intensas ao ar livre durante os horários mais quentes.\n" +
                                    "\n" +
                                    "Ambiente e segurança\n" +
                                    "- Feche cortinas e janelas durante os períodos mais quentes do dia para manter a casa fresca.\n" +
                                    "- Abra as janelas à noite para melhorar a ventilação.\n" +
                                    "- Se estiver em um veículo sem ar-condicionado, mantenha as janelas abertas.\n" +
                                    "\n" +
                                    "Essas práticas ajudam a reduzir os riscos à saúde e garantem mais conforto durante períodos de calor intenso."
                    );

                    System.out.println("\n---------------------------");
                    System.out.println("Deseja voltar ao menu? ");
                    System.out.println("1- SIM" +
                            "           \n2- NÃO");
                    System.out.println("---------------------------");

                    int opcaoVoltar3 = 0;
                    boolean voltarValido3 = false;
                    do {
                        if (sc.hasNextInt()) {
                            opcaoVoltar3 = sc.nextInt();
                            sc.nextLine(); // limpar buffer
                            if (opcaoVoltar3 == 1 || opcaoVoltar3 == 2) {
                                voltarValido3 = true;
                            } else {
                                System.out.println("Digite 1 para SIM ou 2 para NÃO.");
                            }
                        } else {
                            System.out.println("Digite apenas números!");
                            sc.nextLine(); // limpar entrada inválida
                        }
                    } while (!voltarValido3);

                    sairProg = (opcaoVoltar3 == 1);

                    break;

                case 4:
                    sairProg = false;
                    break;

                default:
                    System.out.println("Opção inválida! Digite um número entre 1 e 4.");
                    break;
            }

        } while (sairProg);

        System.out.println("---------------------------------------------------------------");
        System.out.println("PROGRAMA ENCERRADO! CUIDE-SE DURANTE AS ALTAS ONDAS DE CALOR!!");
        System.out.println("---------------------------------------------------------------");
    }
}
