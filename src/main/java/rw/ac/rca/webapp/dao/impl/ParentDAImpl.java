package rw.ac.rca.webapp.dao.impl;
import org.hibernate.Query;
import rw.ac.rca.webapp.dao.ParentDAO;
import rw.ac.rca.webapp.orm.Parent;
import java.util.List;

public class ParentDAImpl extends DAO implements ParentDAO {
    private static ParentDAImpl instance;
    public static ParentDAImpl getInstance(){
        if(instance == null){
            return new ParentDAImpl();
        }
        return instance;
    }
    @Override
    public List<Parent> getAllParents() {
        try{
            begin();
            Query query = getSession().createQuery("from Parent");
            List<Parent> parents = query.list();
            System.out.println("================== parents ==================== " + parents);
            commit();
            return  parents;
        }catch (Exception exception){
            System.out.println("Error , failed to get parents list : " + exception.getMessage());
            rollback();
            return  null;
        }
    }
    @Override
    public Parent registerParent(Parent parent) {
        try{
            begin();
            getSession().saveOrUpdate(parent);
            commit();
            return parent;

        }catch (Exception e){
            System.out.println("Error, failed to save an parent : " + e.getMessage());
            rollback();
            return null;
        }
    }
}
