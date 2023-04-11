package dio.web.api.handler;

public class CampoObrigatorioException extends BusinessException {
    public CampoObrigatorioException(String mensagem) {
        super("O campo %s é obrigatódio",mensagem);
    }
}
