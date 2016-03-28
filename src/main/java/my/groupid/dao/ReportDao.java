package my.groupid.dao;

import java.util.List;

import my.groupid.api.ReportDTO;

public interface ReportDao {

	List<ReportDTO> findByCategoryId(String categoryId);
	
	List<ReportDTO> findAll();

}