package kodlamaio.hrms.core.adapters.mernis;

import java.rmi.RemoteException;

public interface MernisService {
	boolean checkUser(String nationalId,String firstName,String lastName,int birthYear) throws NumberFormatException, RemoteException ;
}
