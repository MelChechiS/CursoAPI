package br.com.etec.mel.cursoapi.repository.projections;

public class AlunoDto {

    private Long id;

    private String nomealuno;

    private String nomecidade;

    private String UF;

    private String nomecurso;

    public AlunoDto(Long id, String nomealuno, String nomecidade, String UF, String nomecurso) {
        this.id = id;
        this.nomealuno = nomealuno;
        this.nomecidade = nomecidade;
        this.UF = UF;
        this.nomecurso = nomecurso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomealuno() {
        return nomealuno;
    }

    public void setNomealuno(String nomealuno) {
        this.nomealuno = nomealuno;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getNomecurso() {
        return nomecurso;
    }

    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }
}
