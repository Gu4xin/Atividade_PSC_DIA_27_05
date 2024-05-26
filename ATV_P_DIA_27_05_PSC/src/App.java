import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        String caminhoDoArquivoTexto = "C:\\User\\Fulano\\Documentos..."; //Caminho onde o texto vai
        String caminhoDoArquivoLog = "C:\\User\\Fulano\\Documentos\\Logs"; //Caminho onde o log vai
        
        System.out.println("Digite o texto que deseja salvar no arquivo: ");
        String texto = teclado.nextLine();

        try (FileWriter escritorTexto = new FileWriter(caminhoDoArquivoTexto);
            FileWriter escritorLog = new FileWriter(caminhoDoArquivoLog, true);
            PrintWriter gravadorLog = new PrintWriter(escritorLog)) {

            escritorTexto.write(texto);
            System.out.println("Texto salvo no arquivo " + caminhoDoArquivoTexto);

            gravadorLog.println("Operação concluida com sucesso.");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo.");
            e.printStackTrace();
            try (FileWriter escritorLog = new FileWriter(caminhoDoArquivoLog, true);
            PrintWriter gravadorLog = new PrintWriter(escritorLog)) {

                gravadorLog.println("Erro: " + e.getMessage());

            } catch (IOException ioException) {
                System.out.println("Erro ao escrever no arquivo do log.");
                ioException.printStackTrace();
                
            }

        } finally {
            teclado.close();
        }
    }
}
