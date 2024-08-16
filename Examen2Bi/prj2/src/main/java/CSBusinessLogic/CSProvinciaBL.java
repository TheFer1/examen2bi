package CSBusinessLogic;

import CSDataAccess.CSDAO.CSProvinciaDao;
import CSDataAccess.CSDTO.CSProvinciaDto;
import java.util.List;

public class CSProvinciaBL {
    private CSProvinciaDao csProvinciaDao ;

    public CSProvinciaBL(){ 
        csProvinciaDao = new CSProvinciaDao() ;}

    public boolean csAdd(CSProvinciaDto CSProvinciaDto)throws Exception{
        return csProvinciaDao.csCreate(CSProvinciaDto);
    }
    public List<CSProvinciaDto> csGetAll() throws Exception{
        return csProvinciaDao.csReadAll();
    }
    public boolean csUpdate(CSProvinciaDto CSProvinciaDto) throws Exception{
        return csProvinciaDao.csUpdate(CSProvinciaDto);
    }

    public boolean csDelete(int idCSProvincia) throws Exception { 
        return csProvinciaDao.csDelete(idCSProvincia); 
    }

    public CSProvinciaDto csGetBy(int idCSProvincia ) throws Exception{
        return csProvinciaDao.readBy(idCSProvincia) ;
    }

}
