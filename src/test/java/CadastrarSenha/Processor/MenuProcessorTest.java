//package CadastrarSenha.Processor;
//
//import CadastrarSenha.BootTelegramApi.TelaBot;
//import CadastrarSenha.Repository.Login.ConsultasRepository;
//import CadastrarSenha.Repository.Login.LoginRepository;
//import CadastrarSenha.View.Menu;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.util.Scanner;
//
//import static org.mockito.Mockito.*;
//
//class MenuProcessorTest {
//
//    private MenuProcessor menuProcessor;
//    private TelaBot mockBot;
//    private ConsultasRepository mockConsultaRepository;
//    private LoginRepository mockLoginRepository;
//    private Menu mockMenu;
//    private Scanner mockScanner;
//
//    @BeforeEach
//    void setUp() {
//        // Criando os mocks
//        mockBot = mock(TelaBot.class);
//        mockConsultaRepository = mock(ConsultasRepository.class);
//        mockLoginRepository = mock(LoginRepository.class);
//        mockMenu = mock(Menu.class);
//        mockScanner = mock(Scanner.class);
//
//        // Criando a classe a ser testada
//        menuProcessor = new MenuProcessor();
//
//        // Substituindo os atributos reais pelos mocks
//        menuProcessor.bot = mockBot;
//        menuProcessor.consultaRepository = mockConsultaRepository;
//        menuProcessor.loginRepository = mockLoginRepository;
//        menuProcessor.leia = mockScanner;
//    }
//
//    @Test
//    void testMenuPrincipalCadastrar() throws Throwable {
//        // Simulando a entrada do usuário para "1"
//        when(mockScanner.nextInt()).thenReturn(1);
//
//        // Executando o método
//        menuProcessor.menuPrincipal();
//
//        // Verificando as interações
//        verify(mockBot).ligarApi();
//        verify(mockMenu).menuParente(Menu.valor);
//        verify(mockScanner).close();
//    }
//
//    @Test
//    void testMenuPrincipalLoginPerdiSenha() throws Throwable {
//        // Simulando a entrada do usuário para "2"
//        when(mockScanner.nextInt()).thenReturn(2);
//
//        // Executando o método
//        menuProcessor.menuPrincipal();
//
//        // Verificando as interações
//        verify(mockBot).ligarApi();
//        verify(mockConsultaRepository).pesquisaNaListaDeUsuarios();
//        verify(mockScanner).close();
//    }
//
//    @Test
//    void testMenuPrincipalLoginDireto() throws Throwable {
//        // Simulando a entrada do usuário para "3"
//        when(mockScanner.nextInt()).thenReturn(3);
//
//        // Executando o método
//        menuProcessor.menuPrincipal();
//
//        // Verificando as interações
//        verify(mockBot).ligarApi();
//        verify(mockLoginRepository).acessoLogin();
//        verify(mockScanner).close();
//    }
//
//    @Test
//    void testMenuPrincipalValorInvalido() throws Throwable {
//        // Simulando a entrada do usuário para um valor inválido
//        when(mockScanner.nextInt()).thenReturn(99);
//
//        // Executando o método
//        menuProcessor.menuPrincipal();
//
//        // Verificando se o método menuValorInvalido foi chamado
//        verify(mockBot).ligarApi();
//        // Como o método menuValorInvalido é chamado recursivamente,
//        // você pode verificar se ele tenta relançar o menu principal.
//    }
//}
