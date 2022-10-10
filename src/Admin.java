public class Admin extends Usuario {
    private String nome;
    private Long id;

    public Admin(String username, String senha, String nome, Long id) {
        super(username, senha);
        this.nome = nome;
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getName(){
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
