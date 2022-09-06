package com.serinz.activos.app.services.areas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.serinz.activos.app.configs.exceptions.BadRequestException;
import com.serinz.activos.app.configs.exceptions.InternalServerError;
import com.serinz.activos.app.configs.exceptions.NotFoundException;
import com.serinz.activos.app.dao.AreaDAO;
import com.serinz.activos.app.entitys.Area;

/**
 * Etapa de implementacion de servicios para las peticiones Http del Modelo Area
 * @author ing_j
 *
 */
@Service
public class AreaServiceImpl implements IAreaService {
	
	@Autowired
	private AreaDAO areaDAO;
	
	@Override
	public List<Area> getAreas() {
		// TODO Auto-generated method stub
		return areaDAO.findAll();
	}

	@Override
	public Area addArea(Area area) {

			return areaDAO.save(area);

	}

	@Override
	public Area updateArea(Area putArea) {
		if(putArea == null ) {
			throw new InternalServerError("/Erro/ - El Area no puede ser nula", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(!areaDAO.existsById(putArea.getCodArea())) {
			throw new NotFoundException("/Error/ - El área en consulta no existe");
		}
		if(putArea.getNameArea() == null) {
			throw new BadRequestException("/Error/ - El área no puede ser nula o vacia");
		}
		return areaDAO.save(putArea);
	}

	@Override
	public String deleteArea(String codArea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Area findAreaById(int codArea) {
		if(!areaDAO.existsById(codArea)) {
			throw new NotFoundException("/Error/ - Area no existente");
		}
		return areaDAO.findById(codArea).orElse(null);
	}
	

}
