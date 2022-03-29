import java.util.List;

import com.curso.modelo.entidad.Cliente;

public interface ClienteDao extends InterfazDao<Cliente, Integer>{

	List<Cliente> buscarPorCiudad(String ciudad);
	
}
