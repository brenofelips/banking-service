package domain.messaging;

public class AgenciaMessage {
  private Long id;
  private String nome;
  private String razaoSocial;
  private String cnpj;
  private String situacaoCadastral;

  public AgenciaMessage(String nome, String razaoSocial, String cnpj, String situacaoCadastral) {
    this.nome = nome;
    this.razaoSocial = razaoSocial;
    this.cnpj = cnpj;
    this.situacaoCadastral = situacaoCadastral;
  }

  public AgenciaMessage() {

  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getSituacaoCadastral() {
    return situacaoCadastral;
  }
}
