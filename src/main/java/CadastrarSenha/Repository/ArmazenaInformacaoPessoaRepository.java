package CadastrarSenha.Repository;

import CadastrarSenha.Service.FamiliarService;
import CadastrarSenha.Util.Menu;
import CadastrarSenha.Util.Variavel.VarFamiliar;
import CadastrarSenha.jdbc.DAO.Conexao;

import static CadastrarSenha.Service.FamiliarService.confirmaPatriarca;
import static CadastrarSenha.Util.Menu.nomePaiArmazenado;

public class ArmazenaInformacaoPessoaRepository {

    VarFamiliar varFamiliar = new VarFamiliar();
    Conexao dao = new Conexao();
    FamiliarService familiarService = new FamiliarService();
    Menu menu = new Menu();

    public void ArmazenaInfo() {
        String pai = "";
        String teste = "";

        menu.menuParente(varFamiliar.getValorMenu());
        familiarService.patriarca(varFamiliar.getPai());
        pai = nomePaiArmazenado;
        teste = confirmaPatriarca;

            String sql = "INSERT INTO pessoas (nome, C_Familia) values(?,?)";
            dao.incluir(sql, pai,teste);
            System.out.println("INFORMAÇÕES NO BANCO");
        }

    public static void main(String[] args) {
        ArmazenaInformacaoPessoaRepository teste = new ArmazenaInformacaoPessoaRepository();

        teste.ArmazenaInfo();
    }
}