import java.util.List;

public interface ClienteDAO{
    public List<Cliente> getAllCLientes();
    public Cliente getCLiente(int id);
    public Cliente updateCLiente(Cliente cliente);
    public void insertCLiente(Cliente cliente);
}
