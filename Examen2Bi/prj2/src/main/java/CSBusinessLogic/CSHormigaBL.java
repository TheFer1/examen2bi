package CSBusinessLogic;

import CSDataAccess.CSDAO.CSHormigaDao;
import CSDataAccess.CSDTO.CSHormigaDto;

import java.util.*;
public class CSHormigaBL {
    private CSHormigaDao csHormigaDao;

    public CSHormigaBL() {
        csHormigaDao = new CSHormigaDao() ; 
    } 
    
        public boolean csAdd(CSHormigaDto CSHormigaDto) throws Exception{   
        return csHormigaDao.csCreate(CSHormigaDto);
    }

    public List<CSHormigaDto> csGetAll()throws Exception {
        return csHormigaDao.csReadAll() ;
    }
       public boolean csUpdate(CSHormigaDto CSHormigaDto) throws Exception{
        return csHormigaDao.csUpdate(CSHormigaDto);
    }
    
    public boolean csDelete(int idCSHormiga) throws Exception{
        return csHormigaDao.csDelete(idCSHormiga);
    }

        public CSHormigaDto csGetBy(int idCSHormiga) throws Exception{
        return csHormigaDao.readBy(idCSHormiga);
    }


}
