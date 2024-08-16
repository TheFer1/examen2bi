package CSBusinessLogic;

import CSDataAccess.CSDAO.CSSexoDao;
import CSDataAccess.CSDTO.CSSexoDto;
import java.util.List;

public class CSSexoBL {
    private CSSexoDao csSexoDao ;
    

        public CSSexoBL() {
            csSexoDao = new CSSexoDao() ; 
    }

        public boolean csAdd(CSSexoDto CSSexoDto) throws Exception{   
        return csSexoDao.csCreate(CSSexoDto);
    }
    
    public List<CSSexoDto> csGetAll()throws Exception {
        return csSexoDao.csReadAll() ;
    }
    public boolean csUpdate(CSSexoDto CSSexoDto) throws Exception{
        return csSexoDao.csUpdate(CSSexoDto);
    }
    public boolean csDelete(int idCSSexo) throws Exception{
        return csSexoDao.csDelete(idCSSexo);
    }

    public CSSexoDto csGetBy(int idCSSexo) throws Exception{
        return csSexoDao.readBy(idCSSexo);
    }


}
