package kodlamaio.hrms.adapters;

import java.rmi.RemoteException;

public interface MernisService {
	boolean checkUser(String nationalId,String firstName,String lastName,int birthYear) throws NumberFormatException, RemoteException ;
}
