package CadastrarSenha.jdbc.BD;

import CadastrarSenha.Service.FamiliarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class listas {
    static FamiliarService service = new FamiliarService();
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < 3;i++ ) {
            String valor = leia.nextLine();
            lista.add(valor);
            System.out.println(lista.get(i));


        lista.add(service.toString());


        }
    }
}
