package CSBusinessLogic;

import CSDataAccess.CSDAO.CSPaisDao;
import CSDataAccess.CSDTO.CSPaisDto;
import java.util.List;

public class CSPaisBL {    
    private CSPaisDao csPaisDao  ; 

    public CSPaisBL (){
        csPaisDao = new CSPaisDao();
    }

    public boolean csAdd(CSPaisDto CSPaisDto) throws Exception{   
        return csPaisDao.csCreate(CSPaisDto);
    }
    
    public List<CSPaisDto> csGetAll()throws Exception {
        return csPaisDao.csReadAll() ;
    }
    public boolean csUpdate(CSPaisDto CSPaisDto) throws Exception{
        return csPaisDao.csUpdate(CSPaisDto);
    }
    public boolean csDelete(int idCSPais) throws Exception{
        return csPaisDao.csDelete(idCSPais);
    }

    public CSPaisDto csGetBy(int idCSPais) throws Exception{
        return csPaisDao.readBy(idCSPais);
    }
}
