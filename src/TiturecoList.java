import java.util.ArrayList;
import java.util.List;

public class TiturecoList implements TiturecoInterface {

    private List<AtrativoTuristico> atrativos;

    public TiturecoList() {
        this.atrativos = new ArrayList<>();
    }

    @Override
    public boolean cadastrarAtrativo(AtrativoTuristico atrativo) {
        if (!atrativos.contains(atrativo)) {
            atrativos.add(atrativo);
            return true;
        }
        return false;
    }

    @Override
    public boolean apagarAtrativo(String nomeAtrativo, String cidade, String estado) {
        AtrativoTuristico alvo = new AtrativoTuristico();
        alvo.setNome(nomeAtrativo);
        alvo.setCidade(cidade);
        alvo.setEstado(estado);

        return atrativos.remove(alvo);
    }

    @Override
    public List<AtrativoTuristico> getAtrativos() {
        return this.atrativos;
    }

    @Override
    public List<AtrativoTuristico> pesquisaAtrativosDaCidade(String cidade, String estado) {
        List<AtrativoTuristico> resultados = new ArrayList<>();
        for (AtrativoTuristico a : atrativos) {
            if (a.getCidade().equalsIgnoreCase(cidade) && a.getEstado().equalsIgnoreCase(estado)) {
                resultados.add(a);
            }
        }
        return resultados;
    }
}