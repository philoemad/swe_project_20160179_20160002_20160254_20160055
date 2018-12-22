package TheFinder;
import java.sql.SQLException;
import java.util.Vector;

public class search_service {
	 public Vector <searchForm> searchvector;
	searchForm search=new searchForm();
	DataBase data=new DataBase();
	public Vector <DataBase> datas;
	//searchvector
	public void dosearch(String cat) throws SQLException {
		data.SearchPost(cat);
	}
}
