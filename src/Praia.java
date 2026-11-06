public class Praia extends AtrativoTuristico {

    public static final String TIPO_PISCINAS_NATURAIS = "Piscinas Naturais";
    public static final String TIPO_ONDAS_FORTES = "Ondas Fortes";
    public static final String TIPO_ONDAS_MEDIAS = "Ondas Médias";

    private boolean propriaParaBanho;
    private boolean perigoTubarao;
    private String tipoOrla;

    public Praia() {
        super();
    }

    public Praia(String nome, double latitude, double longitude, String comoChegar, String cidade, String estado, boolean propriaParaBanho, boolean perigoTubarao, String tipoOrla) {
        super(nome, latitude, longitude, comoChegar, cidade, estado);
        this.propriaParaBanho = propriaParaBanho;
        this.perigoTubarao = perigoTubarao;
        this.tipoOrla = tipoOrla;
    }

    public boolean ehPropriaParaBanho() {
        return propriaParaBanho; }
    public void setPropriaParaBanho(boolean ehPropria) {
        this.propriaParaBanho = ehPropria; }

    public boolean temPerigoTubarao() {
        return perigoTubarao; }
    public void setPerigoTubarao(boolean temPerigo) {
        this.perigoTubarao = temPerigo; }

    public String getTipoOrla() {
        return tipoOrla; }
    public void setTipoOrla(String tipo) {
        this.tipoOrla = tipo; }
}