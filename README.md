# Fechadura Digital
[Read-me em construcao] ....

## Construão do teclado 

Fechadura digital Baseada , com duas configuracoes diferentes, quando colocando a senhaService correta abrira,
se colocado uma senha SOS já configurada no ato da configuracao inicial
será destrancadas apenas algumas portas, podendo ganhar tempo para ate a policia ser avisada, enviando imediatamente um SOS 
para a policia e mais uma para o numero já configurado como Patriarca/Matriarca.
Para esses casos nâo sera utilizada reconhecimeno facial apenas senha pelo teclado neste trecho.

* CRIACAO DE FECHADURA DIGITAL

![FechaduraEletronica.jpg](..%2F..%2FDiagramaFechadura%2FFechaduraEletronica.jpg)
* Cadastro de senhaService *

![img.png](Diagramas/img.png)

#### Ao escolher a opção de cadastrar a senhaService entra na opção de familiarService entrando no menu com 4 opções
```
|----------------------------|
|1 - Pai (PATRIARCA)         |
|----------------------------|
|2 - Mae (MATRIARCA)         |
|----------------------------|
|3 - Filhos                  |
|----------------------------|
|4 - Outros                  |
|----------------------------|
```

Contendo dois tipos de **PATRIARCAS** **Pai** ou **Mãe**, será necessario para poder ter acesso as movimentações mais 
tarde, podendo ter apenas um patriarca por familia 

![CriandoParentesco.drawio.png](..%2F..%2FDiagramaFechadura%2FParente%20Cadastro%2FCriandoParentesco.drawio.png)

Para filhos e outros não terá necessidade de ter acesso as movimentações, porém devera fazer cadastro normalmente assim como os demais

Cada um devera ter uma conta previa no telegram para atos de confirmações no sistema, alem do cpf e uma senha separada de cada usuario 
sendo eles 

- Pai
- Mae
- Filhos
- Outros

Não há uma quantidade especifica de filhos ou outros que devera se cadastrar, apenas para Patriarca/Matriarca sera imposto uma unica vez





### INTERACAO COM TELEGRAM  

Patriarcas/Matriarca sera enviado um codigo pelo telegram, para atos de confirmação de segurança, devera ser informado no painel do sistemas.


![Api Telegram.drawio.png](..%2F..%2FDiagramaFechadura%2FApi%20Telegram%2FApi%20Telegram.drawio.png)






[READ-ME em contrucao] ...