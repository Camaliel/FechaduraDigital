package CadastrarSenha.jdbc;

import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.util.Scanner;

public class IncluiPessoa {
    VarFamiliar  varFamiliar = new VarFamiliar();
    FamiliarService familiarService = new FamiliarService();

    public void incluiNomePessoa() {
        Scanner leia = new Scanner(System.in);
        Conexao dao = new Conexao();

        String nome = leia.nextLine();
        String cFamilia = leia.nextLine();
        // TODO INCLUIR PATROIARCA JUNTO COM O NOME, TALVEZ, ESTUDAR IDEIA [LEMBRETE]

        String sql = "INSERT INTO pessoas (nome,C_Familia) VALUES(?,?)";
        dao.incluir(sql, nome, cFamilia);

        if (!nome.isBlank() && nome != null) {
            System.out.println("Nomes incluidos com sucesso");
        } else {
            System.out.println("Nome nao inserido");
        }
    }


    public static void main(String[] args) {
        IncluiPessoa incluiPessoa = new IncluiPessoa();
        incluiPessoa.incluiNomePessoa();
    }
}