package CadastrarSenha.jdbc.DAO;

import CadastrarSenha.jdbc.CriarConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    private Connection conexao;

    public int incluir(String sql, Object... atributos){
        try{
            PreparedStatement preparedStatement = getConexao().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributo(preparedStatement, atributos);

      if (preparedStatement.executeUpdate() > 0){
          ResultSet resultado = preparedStatement.getGeneratedKeys();
          if (resultado.next()){
              return resultado.getInt(1);
          }
      }
      return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private  void  adicionarAtributo(PreparedStatement statement, Object[] atributos) throws SQLException {

        int indice = 1;
        for (Object atributo: atributos){
            if (atributo instanceof String){
                statement.setString(indice, (String) atributo);
            } else if (atributo instanceof Integer) {
                statement.setInt(indice, (Integer) atributo);
                
            }
            indice++;
        }
    }
    private Connection getConexao(){
        try {
            if (conexao != null && conexao.isClosed()){
                return conexao;
            }
        } catch (SQLException e) {

        }
        conexao = CriarConexao.getConnetion();
        return conexao;

    }
}