package CadastrarSenha.Service;

import CadastrarSenha.Util.Variavel.InfoUsuario;
import org.glassfish.grizzly.streams.Input;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CpfServiceTest {

    private CpfService cpfService;
//    private InfoUsuario infoUsuario;


    @Mock
    InfoUsuario infoUsuario;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        cpfService = new CpfService();
//        infoUsuario = new InfoUsuario();
    }

    @Test
    public void verificaQuantidadeDigitadoCPF() {
        // Mockar as dependências
        String cpf = "12345678901";
        when(cpfService.infoUsuario.setCpf(cpf)).thenReturn("12345678901");

        String resultado = cpfService.infoUsuario.getCpf();

        assertEquals(resultado,"12345678901");


    }



    @Test
    public void confirmaCPFDigitado() {
    }

    @Test
    public void adicionaNumero() {
    }

    @Test
    public void cadastroSenha() {
    }
}