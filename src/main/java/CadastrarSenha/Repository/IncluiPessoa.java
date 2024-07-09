package CadastrarSenha.Repository;

import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import CadastrarSenha.jdbc.DAO.Conexao;

import java.util.Scanner;

public class IncluiPessoa {
    VarFamiliar varFamiliar = new VarFamiliar();
    FamiliarService familiarService = new FamiliarService();

    public void incluiNomePessoa() {
        Scanner leia = new Scanner(System.in);
        Conexao dao = new Conexao();

        String nome = leia.next();
//        String cFamilia = leia.next();
        // TODO INCLUIR PATROIARCA JUNTO COM O NOME, TALVEZ, ESTUDAR IDEIA [LEMBRETE]

        String sql = "INSERT INTO cadastro (nome) VALUES(?)";
        dao.incluir(sql, nome);

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