package CSDataAccess.CSDAO;

import java.util.List;

public interface CSIDao<T> {
    public Boolean csCreate(T entity) throws Exception ; 
    public List<T> csReadAll() throws Exception ; 
    public boolean csUpdate(Integer id) throws Exception ; 
    public boolean csDelete(Integer id) throws Exception; 


}
