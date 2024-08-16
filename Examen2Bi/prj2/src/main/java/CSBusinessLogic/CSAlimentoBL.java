package CSBusinessLogic;

import CSDataAccess.CSDAO.CSAlimentoDao;
import CSDataAccess.CSDTO.CSAlimentoDto;

import java.util.List;

public class CSAlimentoBL {
    private CSAlimentoDao  csAlimentoDao ; 

    
    public CSAlimentoBL() throws Exception {
        csAlimentoDao = new CSAlimentoDao();
    }

    public boolean csAdd(CSAlimentoDto CSAlimentoDto) throws Exception{   
        return csAlimentoDao.csCreate(CSAlimentoDto);
    }

    public List<CSAlimentoDto> csGetAll()throws Exception {
        return csAlimentoDao.csReadAll() ;
    }
       public boolean csUpdate(CSAlimentoDto CSAlimentoDto) throws Exception{
        return csAlimentoDao.csUpdate(CSAlimentoDto);
    }
    
    public boolean csDelete(int idCSAlimento) throws Exception{
        return csAlimentoDao.csDelete(idCSAlimento);
    }

        public CSAlimentoDto csGetBy(int idCSAlimento) throws Exception{
        return csAlimentoDao.readBy(idCSAlimento);
    }



    

}
