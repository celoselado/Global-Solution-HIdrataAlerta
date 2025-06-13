# Importando a biblioteca requests. Usar o comando pip install requests no TERMINAL 
import requests

# Salvando a chave em uma variável 
API_KEY = "c96a615763eff6f3da2c2ea666300040"

# Função para obeter o IP
def obter_ip_publico():
    try:
        response = requests.get("https://api.ipify.org?format=json", timeout=5)
        response.raise_for_status()
        return response.json().get("ip")
    except Exception as e:
        print(f"Erro ao obter IP público: {e}")
        return None

# Função para obter a cidade através do IP
def obter_cidade_por_ip(ip):
    try:
        response = requests.get(f"https://ipinfo.io/{ip}/json", timeout=5)
        response.raise_for_status()
        dados = response.json()
        cidade = dados.get("city")
        if cidade:
            return cidade
        else:
            print(f"Dados recebidos da API: {dados}")
            return None
    except Exception as e:
        print(f"Erro ao obter cidade: {e}")
        return None

# Verificar se a cidade foi puxada através do IP
ip = obter_ip_publico()
if ip:
    cidade = obter_cidade_por_ip(ip)
else:
    print("Algo deu errado...")

# Salvando a chave da API openweather em uma variável
link = f"https://api.openweathermap.org/data/2.5/weather?q={cidade}&appid={API_KEY}&lang=pt_br"

# Usando API requests de acordo com a documentação
requisicao = requests.get(link)
requisicao_dic = requisicao.json()

#Utilizção de Lista _Dic
descricao = requisicao_dic['weather'][0]['description']
temperatura = requisicao_dic['main']['temp'] - 273.15

temperatura = int(temperatura)

# Funções para apresentar dados
def apresentar_perguntas():
    print("---------------------------------------------------")
    print("\nOnda de Calor: Informações e Cuidados\n\n"
    " O que é uma onda de calor?\n"
    "R =Uma onda de calor ocorre quando a temperatura fica acima do normal por vários dias consecutivos.\n\n"
    " Quem são os mais vulneráveis ao calor extremo?\n"
    "R= Bebês, crianças pequenas, idosos, mulheres grávidas e pessoas com doenças crônicas são mais suscetíveis aos efeitos do calor.\n\n"
    " Quais são os principais riscos à saúde?\n"
    "R= O calor extremo pode causar desidratação, insolação, queda de pressão arterial, problemas cardiovasculares e até insuficiência renal.\n\n"
    " Como prevenir problemas de saúde durante uma onda de calor?\n"
    "- Hidrate-se: Beba bastante água, mesmo sem sentir sede.\n"
    "- Evite exposição ao sol: Especialmente entre 10h e 16h.\n"
    "- Use roupas leves: Prefira tecidos como algodão.\n"
    "- Cuide da alimentação: Consuma frutas ricas em água, como melancia e melão.\n\n"
    " Como proteger crianças e idosos?\n"
    "- Ofereça água frequentemente, pois eles podem não perceber a sede.\n"
    "- Evite atividades físicas intensas ao ar livre durante os horários mais quentes.\n"
    "- Mantenha ambientes frescos e ventilados.\n\n"
    " O que fazer em caso de insolação?\n"
    "R= Se alguém apresentar sintomas como tontura, pele quente e seca, confusão mental ou desmaio, leve a pessoa para um local fresco, ofereça líquidos e procure atendimento médico imediatamente.\n")

def apresentar_praticas():
    print("---------------------------------------------------")
    print("\nPráticas essenciais de saúde e segurança para enfrentar ondas de calor extremo\n\n"
    " Proteção contra o calor\n"
    "- Use roupas leves, de cores claras e confortáveis.\n"
    "- Aplique protetor solar regularmente, cobrindo todas as áreas expostas.\n"
    "- Use chapéus, óculos escuros e mantenha-se em locais frescos sempre que possível.\n\n"
    " Cuidados com crianças e idosos\n"
    "- Ofereça água frequentemente, pois eles podem não perceber a sede.\n"
    "- Mantenha ambientes bem ventilados ou climatizados.\n"
    "- Evite atividades físicas intensas ao ar livre durante os horários mais quentes.\n\n"
    " Ambiente e segurança\n"
    "- Feche cortinas e janelas durante os períodos mais quentes do dia para manter a casa fresca.\n"
    "- Abra as janelas à noite para melhorar a ventilação.\n"
    "- Se estiver em um veículo sem ar-condicionado, mantenha as janelas abertas.\n\n"
    " Essas práticas ajudam a reduzir os riscos à saúde e garantem mais conforto durante períodos de calor intenso.\n")

def menu():
    print("---------------------------------------------------")
    print("                   HIDRA ALERTA")
    print("---------------------------------------------------")
    print("1- VERIFICAR TEMPERATURA DA SUA CIDADE" \
    "     \n2- PERGUNTAS MAIS FREQUENTES SOBRE O CALOR" \
    "     \n3- PRÁTICAS ESSÊNCIAIS CONTRA ALTAS TEMPERATURAS " \
    "     \n4- ENCERRAR PROGRAMA " \
    "     \n---------------------------------------------------")

    
continuar_programa = 1

while continuar_programa == 1:
    menu()
    
    entrada = input("DIGITE: ")
    if not entrada.isdigit():
        print("Entrada inválida. Digite um número.")
        continue

    opcao = int(entrada)

    match opcao:
        case 1:
            if temperatura >= 20:
                print("---------------------------------------------------")
                print(cidade, f"{temperatura}°C \n!!!!! TOME ÁGUA PARA SE HIDRATAR !!!!! \nDeseja ver as práticas essências para enfrentar o calor? \n1- SIM \n2- NÃO")
                
                entrada = input("---------------------------------------------------\nDIGITE: ")
                if not entrada.isdigit():
                    print("Entrada inválida. Voltando ao menu.")
                    continue

                opcao = int(entrada)

                if opcao == 1:
                    apresentar_praticas()  
                    print("---------------------------------------------------")
                    print("Deseja voltar ao MENU? \n1- SIM \n2- NÃO")
                    print("---------------------------------------------------")
                    entrada = input("DIGITE: ")
                    if not entrada.isdigit():
                        print("Entrada inválida. Voltando ao menu.")
                        continue

                    opcao = int(entrada)
                    if opcao == 1:
                        continuar_programa = 1
                    else:
                        continuar_programa = 2
                else:
                    continuar_programa = 2
            else:
                print(cidade, descricao, f"{temperatura}°C \nTUDO CERTO! APROVEITE O CLIMA :D")

        case 2:  
            apresentar_perguntas()
            print("---------------------------------------------------")
            print("Deseja voltar ao MENU? \n1- SIM \n2- NÃO")
            print("---------------------------------------------------")
            entrada = input("DIGITE: ")
            if not entrada.isdigit():
                print("Entrada inválida. Voltando ao menu.")
                continue

            opcao = int(entrada)
            if opcao == 1:
                continuar_programa = 1
            else: 
                continuar_programa = 2

        case 3:
            apresentar_praticas()
            print("---------------------------------------------------")
            print("Deseja voltar ao MENU? \n1- SIM \n2- NÃO")
            print("---------------------------------------------------")
            entrada = input("DIGITE: ")     
            if not entrada.isdigit():
                print("Entrada inválida. Voltando ao menu.")
                continue

            opcao = int(entrada)
            if opcao == 1:
                continuar_programa = 1
            else: 
                continuar_programa = 2

        case 4:
            continuar_programa = 2

        case _:
            print("Opção inválida. Tente novamente.")

print("---------------------------------------------------")
print("Programa encerrado. Por favor, se cuide!!!!")
print("---------------------------------------------------")







#print(cidade,descricao, f"{temperatura}°C")

