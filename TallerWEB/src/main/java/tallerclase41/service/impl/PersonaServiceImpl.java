package tallerclase41.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tallerclase41.dao.GenericDao;
import tallerclase41.dao.PersonaDao;
import tallerclase41.dao.impl.PersonaDaoImpl;
import tallerclase41.domain.Ocupacion;
import tallerclase41.domain.Persona;
import tallerclase41.jdbc.AdminConexiones;
import tallerclase41.service.GenericService;
import tallerclase41.service.PersonaService;

public class PersonaServiceImpl implements PersonaService{
	PersonaDao persona = new PersonaDaoImpl();
	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		List<Persona> personas = new ArrayList<>();
		String sql = "SELECT * FROM personas";
		
		try(Connection con = AdminConexiones.obtenerConexion();
			PreparedStatement ps = con.prepareStatement(sql);
				){
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				personas.add(new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6)));
				//Persona(String nombre, String apellido, String ocupacion, Integer edad, Integer documento,Date fechaNacimiento)
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personas;
	}

	@Override
	public Boolean create(Persona persoan) {
		// TODO Auto-generated method stub
		return persona.create(persoan);
	}

	@Override
	public Boolean update(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Integer idPersona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findById(Integer idPersona) {
		// TODO Auto-generated method stub
		return null;
	}

}
