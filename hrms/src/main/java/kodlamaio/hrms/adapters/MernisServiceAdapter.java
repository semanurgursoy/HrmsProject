package kodlamaio.hrms.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean checkUser(String nationalId,String firstName,String lastName,int birthYear) throws NumberFormatException, RemoteException {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		return client.TCKimlikNoDogrula(Long.parseLong(nationalId),firstName,lastName,birthYear);
	}

}
