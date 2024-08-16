package CSBusinessLogic;

import CSDataAccess.CSDAO.CSRegionDao;
import CSDataAccess.CSDTO.CSRegionDto;
import java.util.List;

public class CSRegionBL {
    private CSRegionDao csRegionDao  ;
    public CSRegionBL() {
        csRegionDao = new CSRegionDao() ; 
    } 
        public boolean csAdd(CSRegionDto CSRegionDto) throws Exception{   
        return csRegionDao.csCreate(CSRegionDto);
    }
    
    public List<CSRegionDto> getAll()throws Exception {
        return csRegionDao.csReadAll() ;
    }
    public boolean update(CSRegionDto CSRegionDto) throws Exception{
        return csRegionDao.csUpdate(CSRegionDto);
    }
    public boolean delete(int idCSRegion) throws Exception{
        return csRegionDao.csDelete(idCSRegion);
    }

    public CSRegionDto getBy(int idCSRegion) throws Exception{
        return csRegionDao.readBy(idCSRegion);
    }
    
}
