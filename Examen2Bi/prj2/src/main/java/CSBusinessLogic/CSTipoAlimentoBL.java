package CSBusinessLogic;

import CSDataAccess.CSDAO.CSTipoAlimentoDao;
import CSDataAccess.CSDTO.CSTipoAlimentoDto;
import java.util.List;

public class CSTipoAlimentoBL {
    private CSTipoAlimentoDao csTipoAlimentoDAO;
    public CSTipoAlimentoBL(){
        csTipoAlimentoDAO = new CSTipoAlimentoDao(); 


    }
    
    public boolean csAdd(CSTipoAlimentoDto CSTipoAlimentoDto) throws Exception{   
        return csTipoAlimentoDAO.csCreate(CSTipoAlimentoDto);
    }
    
    public List<CSTipoAlimentoDto> csGetAll()throws Exception {
        return csTipoAlimentoDAO.csReadAll() ;
    }
    public boolean csUpdate(CSTipoAlimentoDto CSTipoAlimentoDto) throws Exception{
        return csTipoAlimentoDAO.csUpdate(CSTipoAlimentoDto);
    }
    public boolean csDelete(int idCSTipoAlimento) throws Exception{
        return csTipoAlimentoDAO.csDelete(idCSTipoAlimento);
    }

    public CSTipoAlimentoDto csGetBy(int idCSTipoAlimento) throws Exception{
        return csTipoAlimentoDAO.readBy(null);
    }



}
