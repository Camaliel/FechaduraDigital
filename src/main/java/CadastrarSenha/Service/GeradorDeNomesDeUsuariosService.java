package CadastrarSenha.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GeradorDeNomesDeUsuariosService {

    public String geradorUsuarios() {

        Random geradorNome = new Random();
        String nome = "";

        Map<Integer, String> listaNomes = new HashMap<>();
        listaNomes.put(1, "João");
        listaNomes.put(2, "Maria");
        listaNomes.put(3, "Pedro");
        listaNomes.put(4, "Ana");
        listaNomes.put(5, "Lucas");
        listaNomes.put(6, "Gabriel");
        listaNomes.put(7, "Isabela");
        listaNomes.put(8, "Mateus");
        listaNomes.put(9, "Helena");
        listaNomes.put(10, "Laura");
        listaNomes.put(11, "Miguel");
        listaNomes.put(12, "Neatriz");
        listaNomes.put(13, "Rafaela");
        listaNomes.put(14, "Clara");
        listaNomes.put(15, "Daniel");
        listaNomes.put(16, "Manuela");
        listaNomes.put(17, "Enzo");
        listaNomes.put(18, "Valentina");
        listaNomes.put(19, "Bernado");
        listaNomes.put(20, "Hector");

        for (int i = 0; i < listaNomes.size(); i++) {
            nome = listaNomes.get(geradorNome.nextInt(19));
        }
        return nome;
    }

    public String geradorSobrenome(){

        Random geradorSobrenome = new Random();
        String sobrenome = "";

        Map<Integer,String>listaSobrenome = new HashMap<>();
        listaSobrenome.put(1,"Silva");
        listaSobrenome.put(2, "Oliveira");
        listaSobrenome.put(3, "Souza");
        listaSobrenome.put(4, "Rodrigues");
        listaSobrenome.put(5, "Almeida");
        listaSobrenome.put(6, "Santos");
        listaSobrenome.put(7, "Pereira");
        listaSobrenome.put(8, "Lima");
        listaSobrenome.put(9, "Cardoso");
        listaSobrenome.put(10, "Teixeira");
        listaSobrenome.put(11, "Mendes");
        listaSobrenome.put(12, "Gomes");
        listaSobrenome.put(13, "Goes");
        listaSobrenome.put(14, "Ribeiro");
        listaSobrenome.put(15, "Faria");
        listaSobrenome.put(16, "Vieira");
        listaSobrenome.put(17, "Costa");
        listaSobrenome.put(18, "Castro");
        listaSobrenome.put(19, "Barros");
        listaSobrenome.put(20, "Duarte");


        for(int i = 0 ; i <= listaSobrenome.size(); i++){
            sobrenome = listaSobrenome.get(geradorSobrenome.nextInt(19));
        }
        return sobrenome;

    }

    public String geradorUltimoNome(){
        Random geradorUltimoNome = new Random();
        String ultimoNome = "";
        Map<Integer,String > listaUltimoNomes = new HashMap<>();
        listaUltimoNomes.put(1, "Fernandes");
        listaUltimoNomes.put(2, "Pinto");
        listaUltimoNomes.put(3, "Borges");
        listaUltimoNomes.put(4, "Machado");
        listaUltimoNomes.put(5, "Barbosa");
        listaUltimoNomes.put(6, "Carvalho");
        listaUltimoNomes.put(7, "Mendonça");
        listaUltimoNomes.put(8, "Leal");
        listaUltimoNomes.put(9, "Nogueira");
        listaUltimoNomes.put(10, "Viana");
        listaUltimoNomes.put(11, "Braga");
        listaUltimoNomes.put(12, "Franco");
        listaUltimoNomes.put(13, "Peixoto");
        listaUltimoNomes.put(14, "Siqueira");
        listaUltimoNomes.put(15, "Tavares");
        listaUltimoNomes.put(16, "Xavier");
        listaUltimoNomes.put(17, "Lopes");
        listaUltimoNomes.put(18, "Coutinho");
        listaUltimoNomes.put(19, "Rios");
        listaUltimoNomes.put(20, "Moreira");


        for (int i = 0; i <= listaUltimoNomes.size(); i++){
            ultimoNome = listaUltimoNomes.get(geradorUltimoNome.nextInt(19));

        }
        return ultimoNome;

    }
    public String geradorAleatorioChefeFamilia(){
        Random geradorChefeFamilia = new Random();
        ArrayList<String>geradoLista = new ArrayList<>();
        geradoLista.add("s");
        geradoLista.add("n");
        geradoLista.add("n");
        String testando = "";


            for (int i = 0;i<= geradoLista.size();i++){
                testando = geradoLista.get(geradorChefeFamilia.nextInt(3));
            }

        return testando ;
    }

    public static void main(String[] args) {
        GeradorDeNomesDeUsuariosService teste = new GeradorDeNomesDeUsuariosService();
//        System.out.println(teste.geradorUsuarios() + " " + teste.geradorSobrenome() + " " +teste.geradorUltimoNome());
        System.out.println(teste.geradorAleatorioChefeFamilia());

    }
}
