package com.serinz.activos.app.services.areas;

import java.util.List;


import com.serinz.activos.app.entitys.Area;


public interface IAreaService {

	public List<Area> getAreas();
	public Area addArea(Area area);
	public Area findAreaById(int codeArea);
	public Area updateArea(Area codArea);
	public String deleteArea(String codArea);
}
